package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import entity.Article;
import entity.RegisteredUser;
import mapper.Mapper;
import persist.Agency;

public class ServerThread extends Thread{

	private int id;
	private Socket socket = null;
	
	public ServerThread(Socket socket,int id) { this.socket = socket; this.id = id;}
	@Override
	public void run() {
		try (
				ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());
		){
			System.out.println(id + " connected");
			boolean ended = false;
			while(ended == false)
			{
				String received = (String) in.readObject();
				String[] input = received.split(" ");
				
				Agency a = Agency.getInstance();
				
				String jsonUser;
				String jsonArticle;
				RegisteredUser ru;
				Article art;
				
				switch (input[0]){
				case "getarticles":
						List<Article> list = a.getAllArticles();
						String jsonArticleList = Mapper.articlesToJson(list);
						out.writeObject(jsonArticleList);
						break;
				case "login":
						jsonUser = input[1];
						ru = Mapper.userFromJson(jsonUser);
						RegisteredUser user = a.getUser(ru.getUsername());
						if (a.existsUser(ru) && user.getPassword().equals(ru.getPassword()))
						{
							if (user.isAdmin())
								out.writeObject("admin");
							else
								out.writeObject("writer");
						}
						else
							out.writeObject("error"); 
						break;
				case "register":
						jsonUser = input[1];
						ru = Mapper.userFromJson(jsonUser);
						if (a.existsUser(ru))
							out.writeObject("error");
						else
						{
							a.addUser(ru);
							out.writeObject("registered");
						}
						break;
				case "article":
						String title = input[1];
						art = a.getArticle(title);
						if (art != null)
						{
							jsonArticle = Mapper.articleToJson(art);
							out.writeObject(jsonArticle);
						}
						else
							out.writeObject("error");
						break;
				case "delete":
						String article = input[1];
						if (article != null)
						{
							art = Mapper.articleFromJson(article);
							System.out.println(art.toString());
							if (a.deleteArticle(art))
								out.writeObject("deleted");
							else out.writeObject("error");
						}
						else
							out.writeObject("error");
						break;
				case "create": out.writeObject("create"); break;
				case "update": out.writeObject("update"); break;
				case "created": 
						jsonArticle = input[1];
						System.out.println(jsonArticle);
						art = Mapper.articleFromJson(jsonArticle);
						if (a.existsArticle(art))
							out.writeObject("error");
						else
						{
							a.addArticle(art);
							out.writeObject("created");
						}
						break;
				case "updated":
						jsonArticle = input[2];
						art = Mapper.articleFromJson(jsonArticle);
						if (a.existsArticle(art))
							out.writeObject("error");
						else
						{
							String oldArticle = input[1];
							Article old = Mapper.articleFromJson(oldArticle);
							a.updateArticle(old, art);
							out.writeObject("updated");
						}
						break;
				case "quit":
						a.serialize();
						ended = true;
						break;
				}
			}
			//a.serialize
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(id + " disconnected");
		}
             
		
	}

}
