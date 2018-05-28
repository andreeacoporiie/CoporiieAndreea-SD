package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import entity.RegisteredUser;
import entity.Article;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mapper.Mapper;

public class GeneralController implements Initializable, Observer {

    @FXML
    private AnchorPane anchor;

    @FXML
    private ListView<Article> articleList;

    @FXML
    private Button loginBTN;

    @FXML
    private TextField userTF;

    @FXML
    private Label welcomeLB;

    @FXML
    private Label dailyLB;

    @FXML
    private PasswordField passTF;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    @FXML
    void login(ActionEvent event) throws IOException, ClassNotFoundException {
    	String user = userTF.getText();
    	String pass = passTF.getText();
    	RegisteredUser ru = new RegisteredUser(user,pass);
    	
    	String jsonUser = Mapper.userToJson(ru);
    	System.out.println(jsonUser);
    	
    	client.getOut().writeObject("login" + " " + jsonUser);
		client.getOut().flush();
		System.out.println("Sent request login");
		
		String answer = (String) client.getIn().readObject();
		switch(answer){
		case "admin": main.changeScene("adminview.fxml");
					  client.setAdminUser(1);
					  break;
		case "writer": main.changeScene("writerview.fxml"); 
					   client.setAdminUser(0);
					   break;
		case "error": Alerts.display("error", "Login Error", "Invalid User"); break;
		}
    }
    
    @FXML 
    void handleMouseClick(MouseEvent arg0) throws IOException {
    	client.setArticle(articleList.getSelectionModel().getSelectedItem());
    	main.changeScene("articleview.fxml");
        System.out.println("clicked on " + articleList.getSelectionModel().getSelectedItem().titleToString());
    }
    
    @FXML
    void init(MouseEvent event) {
    	
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
