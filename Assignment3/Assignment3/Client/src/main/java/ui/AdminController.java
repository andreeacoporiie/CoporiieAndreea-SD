package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import entity.Article;
import entity.RegisteredUser;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mapper.Mapper;

public class AdminController implements Initializable, Observer {

    @FXML
    private AnchorPane anchor;

    @FXML
    private ListView<Article> articleList;

    @FXML
    private Button loginBTN;

    @FXML
    private TextField userTF;

    @FXML
    private TextField passTF;

    @FXML
    private Label welcomeLB;

    @FXML
    private Label dailyLB;

    @FXML
    private Button createBTN;

    Main main = new Main();
    Client client = Client.getInstance();
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			client.getOut().writeObject("getarticles");
			client.getOut().flush();
			System.out.println("Send request getarticle");
			
			String jsonArticleList = (String) client.getIn().readObject();
			List<Article> articles = Mapper.articlesFromJson(jsonArticleList);
			ObservableList<Article> oList= FXCollections.observableArrayList(articles);
			
			articleList.setItems(oList);
			articleList.setEditable(false);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    @FXML
    void createAcc(ActionEvent event) throws IOException, ClassNotFoundException {
    	String user = userTF.getText();
    	String pass = passTF.getText();
    	
    	if (user != null && pass != null) 
    	{
    		RegisteredUser ru = new RegisteredUser(user,pass);
    		String jsonUser = Mapper.userToJson(ru);
    		
    		client.getOut().writeObject("register" + " " + jsonUser);
			client.getOut().flush();
			System.out.println("Send request register");
			
			String answer = (String) client.getIn().readObject();
			if (answer.equals("registered"))
				Alerts.display("info", "User Registration", "A user was successfully registered");
			else
				Alerts.display("error", "Error", "The username is already taken");
    	}
    	
    }
    
    @FXML 
    void handleMouseClick(MouseEvent arg0) throws IOException {
    	client.setArticle(articleList.getSelectionModel().getSelectedItem());
    	main.changeScene("articleview.fxml");
        System.out.println("clicked on " + articleList.getSelectionModel().getSelectedItem().titleToString());
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	main.changeScene("generalview.fxml");
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void exitApplication(ActionEvent event) {
	   Platform.exit();
	}

}
