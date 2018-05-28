package org.UI;

import java.io.IOException;

import entity.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import logic.ModelLogic;

public class LoginController {

    @FXML
    private AnchorPane ping;

    @FXML
    private TextField userTF;

    @FXML
    private PasswordField passTF;

    @FXML
    private Button loginBTN;

    @FXML
    private Button createBTN;

    @FXML
    private Label userLB;

    @FXML
    private Label passLB;

    ModelLogic model = ModelLogic.getInstance();
    
    public static Player user = null;
    
    protected Main m = new Main();
    
    @FXML
    void createAcc(ActionEvent event) {
    	if (model.isPlayer(userTF.getText())) 
    		Alerts.display("error", "Error", "The username is already taken.");
    	else
    	{
    		if ( userTF.getText() == null ||  passTF.getText() == null)
    			Alerts.display("error", "Error", "Please complete both fields");
    		Player p = new Player(model.getPl().getNextId(), userTF.getText(), passTF.getText());
    		model.getPl().addPlayer(p);
    		Alerts.display("info", "Account Creation", "The account has been created. Continue and Log In.");
    	}
    }

    @FXML
    void login(ActionEvent event) throws IOException {
    	if (model.isPlayer(userTF.getText())) 
    	{
    		user = model.getPl().findByMail(userTF.getText());
    		if (user.getPassword().equals(passTF.getText()))
    		{
    			if (user.isAdmin())
    				m.changeScene("adminview.fxml");
    			else
    				m.changeScene("playerview.fxml");
    		}
    		else
    			Alerts.display("error", "Error", "Invalid password");
    	}
    	else
    		Alerts.display("error", "Error", "Invalid username");
    }

}
