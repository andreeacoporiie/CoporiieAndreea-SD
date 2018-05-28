package org.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import entity.Tournament;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.ModelLogic;

public class AdminViewController implements Initializable {

    @FXML
    private TableView<Tournament> tournTable;

    @FXML
    private TableColumn<Tournament, Integer> colId;

    @FXML
    private TableColumn<Tournament, String> colName;

    @FXML
    private TableColumn<Tournament, String> colStatus;

    @FXML
    private TableColumn<Tournament, Integer> colFee;

    @FXML
    private TableColumn<Tournament, Integer> colPrize;

    @FXML
    private TextField idTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField feeTF;

    @FXML
    private TextField prizeTF;

    @FXML
    private Button createBtn;

    @FXML
    private Button DeleteBtn;

    @FXML
    private Button UpdateBtn;

    @FXML
    private Button StartBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button manageBtn;

    @FXML
    private Button viewBtn;

    ModelLogic model = ModelLogic.getInstance();
    
    Main m = new Main();
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
    	colId.setCellValueFactory(new PropertyValueFactory<>("idTournament"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        colPrize.setCellValueFactory(new PropertyValueFactory<>("prize"));
        
        updateTable();
    }
    
    @FXML
    void DeleteTourn(ActionEvent event) {
    	try{
    	int id = Integer.parseInt(idTF.getText());
    	if (model.isTournament(id)) 
    		model.getTl().deleteTournament(model.getTl().findById(id));
    	else
    		Alerts.display("error", "Error", "There is no player with that ID.");
    	} catch (Exception e) {
    		Alerts.display("error", "Error", "Choose tournament's id");
    	}
    	updateTable();
    }

    @FXML
    void createTourn(ActionEvent event) {
    	int id = model.getTl().getNextId();
    	String name = nameTF.getText();
    	int fee = 0;
    	int prize = 0;
    	if (!feeTF.getText().equals("")) fee = Integer.parseInt(feeTF.getText());
    	if (!prizeTF.getText().equals("")) prize = Integer.parseInt(prizeTF.getText());
    	
    	Tournament t = new Tournament(id,name,"UPCOMING",fee,prize);
    	
    	model.getTl().addTournament(t);
    	
    	updateTable();
    }

    @FXML
    void logout(ActionEvent event)  throws IOException {
    	m.changeScene("login.fxml");
    }

    @FXML
    void managePlayers(ActionEvent event) throws IOException {
    	m.changeScene("manageplayer.fxml");
    }

    @FXML
    void startTourn(ActionEvent event) {
    	try {
    	int id = Integer.parseInt(idTF.getText());
    	if (model.isTournament(id))
    	{
    		Tournament t = model.getTl().findById(id);
    		if (t.getEnrolledPlayers().size() == 8)
    		{
    			if (t.getStatus().equals("UPCOMING"))
    			{
    				t.setStatus("ONGOING");
    				updateTable();
    			}
    			else
    				Alerts.display("error", "Error", "The tournament has already started");
    		}
    		else
    			Alerts.display("error", "Error", "The tournament does not have enough players enrolled.");
    	}
    	} catch (Exception e) {
    		Alerts.display("error", "Error", "Invalid input.");
    	}
    }

    @FXML
    void updateTourn(ActionEvent event) {
    	try{
        	int id = Integer.parseInt(idTF.getText());
        	int fee;
        	int prize;
        	
        	if (feeTF.getText().equals("")) fee = 0; 
    			else fee = Integer.parseInt(feeTF.getText());       	
        	if (prizeTF.getText().equals("")) prize = 0; 
				else prize = Integer.parseInt(prizeTF.getText());
        	if (model.isTournament(id))
        	{
        		Tournament t = model.getTl().findById(id);
        		if (!nameTF.getText().equals("")) t.setName(nameTF.getText());
        		if (prize >= 0) t.setPrize(prize);
        		t.setFee(fee);
        		model.getTl().updateTournament(t);
        	}
        	else
        		Alerts.display("error", "Error", "There is no tournament with that ID.");
    	} catch (Exception e) {
    		Alerts.display("error", "Error", "Invalid input.");
    	}
    	
    	updateTable();
    }

    @FXML
    void viewTourn(ActionEvent event) {

    }
    
    void updateTable()
    {
    	 ArrayList<Tournament> tournList = (ArrayList<Tournament>)model.getTl().getAllTournaments();
         ObservableList<Tournament> oTournList = FXCollections.observableArrayList(tournList);
         
         tournTable.setItems(oTournList);
    }

}
