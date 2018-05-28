package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Stage stage = new Stage();
	static Stage firststage;
	Client client = Client.getInstance();
	

	
    @Override
    public void start(Stage primaryStage) throws Exception{
   
        Parent root = FXMLLoader.load(getClass().getResource("generalview.fxml"));
        primaryStage.setTitle("News agency");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        firststage = primaryStage;
        
    }
    
    public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));	
        Scene newScene = new Scene(pane);
		stage.setScene(newScene);
		stage.show();
		if (firststage != null)
			firststage.close();
	}
    
    @Override
    public void stop() throws IOException{
    	client.getOut().writeObject("quit");
		client.getOut().flush();
		System.out.println("Send request getarticle");
		
		System.out.println("quitted");
    }
    
    public static void main(String[] args) throws IOException {

        launch(args);
    }
}
