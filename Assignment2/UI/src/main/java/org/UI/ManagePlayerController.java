package org.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.ModelLogic;
import javafx.scene.control.TableColumn;

public class ManagePlayerController implements Initializable {

    @FXML
    private TableView<Player> playerTable;

    @FXML
    private TableColumn<Player, Integer> colId;

    @FXML
    private TableColumn<Player, String> colUsername;

    @FXML
    private TableColumn<Player, String> colPass;

    @FXML
    private TableColumn<Player, Integer> colAdmin;

    @FXML
    private TableColumn<Player, Integer> colBalance;

    @FXML
    private Button updateBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private TextField idTF;

    @FXML
    private TextField userTF;

    @FXML
    private TextField pwTF;

    @FXML
    private TextField adminTF;

    @FXML
    private TextField balanceTF;

    @FXML
    private Button deleteBtn;
    
    ModelLogic model = ModelLogic.getInstance();
    protected Main m = new Main();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	colId.setCellValueFactory(new PropertyValueFactory<>("idPlayer"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("Mail"));
        colPass.setCellValueFactory(new PropertyValueFactory<>("Password"));
        colAdmin.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));
        colBalance.setCellValueFactory(new PropertyValueFactory<>("Balance"));
    	
        updateTable();
        
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	m.changeScene("login.fxml");
    }
    
    @FXML
    void delete(ActionEvent event) {
    	try{
    	int id = Integer.parseInt(idTF.getText());
    	if (model.isPlayer(id)) 
    		model.getPl().deletePlayer(model.getPl().findById(id));
    	else
    		Alerts.display("error", "Error", "There is no player with that ID.");
    	} catch (Exception e) {
    		Alerts.display("error", "Error", "Choose player's ID.");
    	}
    	
    	updateTable();
    }

    @FXML
    void updatePlayer(ActionEvent event) {
    	try{
    	int id = Integer.parseInt(idTF.getText());
    	int admin;
    	int balance;
    	
    	if (adminTF.getText().equals("")) admin = -1; 
    		else admin = Integer.parseInt(adminTF.getText());
    	if (balanceTF.getText().equals("")) balance = -1; 
    		else balance = Integer.parseInt(balanceTF.getText());
    	
    	if (model.isPlayer(id)) 
    	{
    		Player p = model.getPl().findById(id);
    		if (!userTF.getText().equals("")) p.setMail(userTF.getText());
    		if (!pwTF.getText().equals("")) p.setPassword(pwTF.getText());
    		if (admin == 0 || admin == 1) p.setIsAdmin(admin);
    		if (balance >= 0) p.setBalance(balance);
    		model.getPl().updatePlayer(p);
    	}
    	else
    		Alerts.display("error", "Error", "There is no player with that ID.");
    	} catch (Exception e) {
    		Alerts.display("error", "Error", "Invalid input.");
    	}
    	
    	updateTable();
    }

    void updateTable()
    {
    	ArrayList<Player> playerList = (ArrayList<Player>) model.getPl().getAllPlayers();
        ObservableList<Player> oPlayerList = FXCollections.observableArrayList(playerList);
        
        playerTable.setItems(oPlayerList);
    }
    
}