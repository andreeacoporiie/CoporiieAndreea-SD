package org.UI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static Stage stage = new Stage();
	static Stage firststage;
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("PingPong");
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
    
    public static void main(String[] args) {
        launch(args);
    }
}
