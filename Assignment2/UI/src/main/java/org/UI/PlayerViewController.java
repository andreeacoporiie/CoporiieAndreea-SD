package org.UI;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import entity.Player;
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

public class PlayerViewController implements Initializable {

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
    private TextField categoryTF;

    @FXML
    private TextField feeTF;

    @FXML
    private Button enrollBtn;

    @FXML
    private Button nameBtn;

    @FXML
    private Button categoryBtn;

    @FXML
    private Button typeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button viewBtn;

    @FXML
    private Button playBtn;

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
    	
        ArrayList<Tournament> tournList = (ArrayList<Tournament>) model.getTl().getAllTournaments();
        updateTable(tournList);
        
    }
    
    @FXML
    void enrollPlayer(ActionEvent event) {
    	try{
    	int id = Integer.parseInt(idTF.getText());
    	if (model.isTournament(id))
    	{
    		Tournament t = model.getTl().findById(id);
    		if (t.getEnrolledPlayers().size() < 8)
    		if (!model.isEnrolled(LoginController.user, t))
    			{
    				if (LoginController.user.getBalance() >= t.getFee())
    				{
    					System.out.println(LoginController.user.getMail());
    					List<Player> list = t.getEnrolledPlayers();
    					list.add(LoginController.user);
    					t.setEnrolledPlayers(list);
    					
    					LoginController.user.setBalance(LoginController.user.getBalance() - t.getFee());
    					model.getPl().updatePlayer(LoginController.user);
    				}
    				else
    					Alerts.display("error", "Error", "Not enough money to enroll.");
    			}
    		else
    			Alerts.display("error", "Error", "Already enrolled in this tournament");
    		else
    			Alerts.display("error", "Error", "Too many players enrolled.");
    	}
    	} catch (Exception e){
    		Alerts.display("error", "Error", "Invalid ID.");
    	}
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	m.changeScene("login.fxml");
    }

    @FXML
    void playCurrentMatch(ActionEvent event) {

    }

    @FXML
    void searchByCategory(ActionEvent event) {
    	String category = categoryTF.getText();
    	if (category.equals("UPCOMING") || category.equals("FINISHED") || category.equals("ENROLLED") || category.equals("ONGOING"))
    	{
    		ArrayList<Tournament> tournList = (ArrayList<Tournament>) model.getTl().getAllTournaments();
    		List<Tournament> targetList;
    		targetList = tournList.stream().filter(t -> t.getStatus().equals(category)).collect(Collectors.toList());
    		
    		updateTable(targetList);
    	}
    	else
    		Alerts.display("error", "Error", "Not a valid category name. Try searching with one of the keywords: UPCOMING, ONGOING, ENROLLED, FINISHED.");
    }

    @FXML
    void searchByName(ActionEvent event) {
    	String name = nameTF.getText();
    	if (model.isTournament(name))
    	{
    		ArrayList<Tournament> tournList = (ArrayList<Tournament>) model.getTl().getAllTournaments();
    		List<Tournament> targetList;
    		targetList = tournList.stream().filter(t -> t.getName().equals(name)).collect(Collectors.toList());
    		
    		updateTable(targetList);
    	}
    	else
    		Alerts.display("error", "Error", "There is no tournament with that name.");
    }

    @FXML
    void searchByType(ActionEvent event) {
    	String category = feeTF.getText();
    	ArrayList<Tournament> tournList = (ArrayList<Tournament>) model.getTl().getAllTournaments();
		List<Tournament> targetList;
		
		
    	if (category.equals("paid"))
    	{
    		targetList = tournList.stream().filter(t -> t.getFee() > 0).collect(Collectors.toList());		
    		updateTable(targetList);
    	}
    	else if (category.equals("free"))
    	{
    		targetList = tournList.stream().filter(t -> t.getFee() == 0).collect(Collectors.toList());
    		updateTable(targetList);
    	}
    	else if (!category.equals(""))
    	{
    		int money = Integer.parseInt(feeTF.getText());
    		if (money > 1)
    		{
    			targetList = tournList.stream().filter(t -> t.getFee() < money).collect(Collectors.toList());		
    			updateTable(targetList);
    		}
    		else
    			Alerts.display("error", "Error", "Not a valid value.");
    	}
    	else
    		Alerts.display("error", "Error", "Not a valid type name. Try searching with a positive amount of money or with the keywords: free, paid.");
    }

    @FXML
    void viewTourn(ActionEvent event) {

    }
    
    void updateTable(List<Tournament> tournList){
    	 ObservableList<Tournament> oTournList = FXCollections.observableArrayList(tournList);
    	 
//    	 for(Tournament t: oTournList)
//    	 {
//    		 if (model.isEnrolled(LoginController.user, t))
//    		 {
//    			 t.setStatus("ENROLLED");
//    		 }
//    	 }
    	
         
         tournTable.setItems(oTournList);
    }

}
