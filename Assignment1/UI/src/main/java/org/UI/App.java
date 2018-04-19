package org.UI;

import java.util.ArrayList;

import admin.*;
import entity.Game;
import entity.Match;
import entity.Player;
import entity.Tournament;
import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application
{
	Stage window;
	Scene logInScene, viewScene, tournScene, playerScene;
	TableView<Tournament> tournTable;
	TableView<Player> playerTable;
	
    public static void main( String[] args )
    {
       launch(args);
    }

	@Override
	public void start(Stage mainStage) throws Exception {
		window = mainStage;

		//Log in window
		Label username = new Label("Username");
		TextField usernameText = new TextField();
		Label password = new Label("Password ");
		PasswordField passwordText = new PasswordField();
		Label blank = new Label("    ");
		
		Button login = new Button("Log In");
		Button createAcc = new Button("Create Account");
	
		FlowPane logInLayout = new FlowPane();
	    logInLayout.setVgap(20);
	    logInLayout.setHgap(20);
	    logInLayout.setPadding(new Insets(15,10,0,10));
	    logInLayout.getChildren().addAll(username, usernameText, password, passwordText, blank, login, createAcc);
	    //------------------------------------------------- 
	    
	    // Choose name Window -----------------------------
	    Stage namestage = new Stage();
	    namestage.initModality(Modality.APPLICATION_MODAL);
	    namestage.setTitle("Select name");
	    HBox nameLayout = new HBox();
	    nameLayout.setPadding(new Insets(10,10,10,10));
	    nameLayout.setSpacing(10);
	    Label namee = new Label("Name");
	    TextField nameText = new TextField();
	    Button ok = new Button("Ok");
	    nameLayout.getChildren().addAll(namee, nameText, ok);
	    Scene newname = new Scene(nameLayout);
	    namestage.setScene(newname);
	    //--------------------------------------------------
	    
	    //View tournament---------------------------------------------
		Label viewTournLabel = new Label("Tournaments");
		viewTournLabel.setFont(new Font("Arial",20));
		Button back = new Button("Back");
		AnchorPane tournTableHeader = new AnchorPane();
		tournTableHeader.getChildren().addAll(viewTournLabel,back);
		AnchorPane.setTopAnchor(back, 1.0);
		AnchorPane.setRightAnchor(back, 1.0);
		AnchorPane.setTopAnchor(viewTournLabel, 1.0);
		AnchorPane.setLeftAnchor(viewTournLabel, 1.0);
		
		
		VBox tournTableLayout = new VBox();
		tournTableLayout.setSpacing(5);
		tournTableLayout.setPadding(new Insets(10, 10, 10, 10));

		Button addTourn = new Button("Create");
		Button updateTourn = new Button("Update");
		Button deleteTourn = new Button("Delete");
		TextField nameTourn = new TextField();
		nameTourn.setPromptText("Name");
		TextField winnerTourn = new TextField();
		winnerTourn.setPromptText("Winner");
				
		HBox tfsTourn = new HBox();
		tfsTourn.setSpacing(5);
		tfsTourn.getChildren().addAll(nameTourn, winnerTourn);		
		HBox btnsTourn = new HBox();
		Label blankTourn = new Label("      ");
		btnsTourn.setSpacing(25);
		btnsTourn.getChildren().addAll(blankTourn, addTourn, updateTourn, deleteTourn);	
		//----------------------------------------------------
		
		
		//option page------------------------------------------
		Button viewTourn = new Button("View Tournaments");
		Button logout = new Button("Log Out");
	    
	    VBox viewLayout = new VBox();
	    viewLayout.setAlignment(Pos.CENTER);
	    viewLayout.setSpacing(10);
	    viewLayout.setPadding(new Insets(10,10,10,10));
		viewLayout.getChildren().addAll(viewTourn, logout);
		//---------------------------------------------------
		
		// View Player
		Button managePlayers = new Button("Manage Players");
		Button back2 = new Button("Back");
		VBox playerTableLayout = new VBox();
		playerTableLayout.setSpacing(5);
		playerTableLayout.setPadding(new Insets(10, 10, 10, 10));
		
		Label viewPlayerLabel = new Label("Players");
		viewPlayerLabel.setFont(new Font("Arial",20));
		AnchorPane playerHeader = new AnchorPane();
		playerHeader.getChildren().addAll(viewPlayerLabel,back2);
		AnchorPane.setTopAnchor(back2, 1.0);
		AnchorPane.setRightAnchor(back2, 1.0);
		AnchorPane.setTopAnchor(viewPlayerLabel, 1.0);
		AnchorPane.setLeftAnchor(viewPlayerLabel, 1.0);
		
		Button updatePlayer = new Button("Update");
		Button deletePlayer = new Button("Delete");
		
		HBox btnsPlayer = new HBox();
		btnsPlayer.setSpacing(25);
		btnsPlayer.getChildren().addAll(updatePlayer, deletePlayer);	
		
		TextField idPlayer = new TextField();
		idPlayer.setPromptText("Id");
		TextField userPlayer = new TextField();
		userPlayer.setPromptText("Username");
		TextField passPlayer = new TextField();
		passPlayer.setPromptText("Password");
		TextField namePlayer = new TextField();
		namePlayer.setPromptText("Name");
		TextField adminPlayer = new TextField();
		adminPlayer.setPromptText("Rights");
		
		HBox tfsPlayer = new HBox();
		tfsPlayer.setSpacing(5);
		tfsPlayer.getChildren().addAll(idPlayer,userPlayer,passPlayer,namePlayer,adminPlayer);
		
		
		// tables 
		tournTable = TournamentAdmin.createTournTable();
		playerTable = PlayerAdmin.createPlayerTable();
		playerTable.getSelectionModel().setSelectionMode( SelectionMode.MULTIPLE );
		
		//Match view for admin
		Stage match = new Stage();
		match.initModality(Modality.APPLICATION_MODAL);
		
		GridPane grid = new GridPane();
	    grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setGridLinesVisible(false);
		Scene matches = new Scene(grid);
	    match.setScene(matches);
	    
	    //Player select for tournam
	    Stage player = new Stage();
		player.initModality(Modality.APPLICATION_MODAL);
		
		Button submit = new Button("Select");
		
	    VBox playerSelect = new VBox();
	    playerSelect.setSpacing(5);
	    playerSelect.setPadding(new Insets(10, 10, 10, 10));
	    playerSelect.getChildren().addAll(playerTable,submit);
	    
		playerSelect.setAlignment(Pos.CENTER);
	    player.setTitle("Select players for the tournament");
	    player.setScene(new Scene(playerSelect));
	    
		
		// Btn actions
	    ok.setOnAction(e -> namestage.close());
	    
		login.setOnAction(e ->
		{
			String user = usernameText.getText();
			String pass = passwordText.getText();
			if (PlayerAdmin.validateLogin(user, pass))
			{
				if (PlayerAdmin.isAdmin(user))
				{
					viewLayout.getChildren().remove(logout);
					viewLayout.getChildren().add(managePlayers);
					viewLayout.getChildren().add(logout);
					window.setScene(viewScene);
				}
				else
					window.setScene(viewScene);
			}
			else
				Alerts.display("error", "Error", "Invalid Information");
		});
		
		createAcc.setOnAction(e ->
		{
			String user = usernameText.getText();
			String pass = passwordText.getText();
			String name;
			if (PlayerAdmin.isUser(user))
			{
				Alerts.display("error","Error", "The username is already taken.");
			}
			else
			{	
				namestage.showAndWait();
				name = nameText.getText();
				PlayerAdmin.addUser(user,pass,name);
				Alerts.display("info", "Account Creation", "The account was successfully created. Please continue and log in.");
			}
		});
		
		viewTourn.setOnAction(e ->
		{
			String user = usernameText.getText();
			if (PlayerAdmin.isAdmin(user))
			{
				tournTableLayout.getChildren().clear();
				tournTableLayout.getChildren().addAll(tournTableHeader, tournTable);
				tournTableLayout.getChildren().addAll(tfsTourn, btnsTourn);
			}
			else
			{
				tournTableLayout.getChildren().clear();
				tournTableLayout.getChildren().addAll(tournTableHeader, tournTable);
			}
			window.setScene(tournScene);
		});
		
		addTourn.setOnAction(e ->
		{
			String tournName = nameTourn.getText();
			if (TournamentAdmin.isTournament(tournName))
				Alerts.display("error", "Error", "The tournament already exists.");
			else
			{
				TournamentAdmin.addTournament(tournName);
				Alerts.display("info", "Tournament Creation", "A tournament has been created");
				player.showAndWait();

				
				// refresh table
				refreshTournTable();
				tournTableLayout.getChildren().clear();
				tournTableLayout.getChildren().addAll(tournTableHeader, tournTable);
				tournTableLayout.getChildren().addAll(tfsTourn, btnsTourn);
			}
		});
		
		submit.setOnAction(e ->
		{
			ObservableList<Player> selectedPlayers;
			selectedPlayers = playerTable.getSelectionModel().getSelectedItems();
			
			if (selectedPlayers.size() != 8)
				Alerts.display("error", "Error", "Not enough players");
			else
				for (Player p : selectedPlayers)
				{
					if (PlayerAdmin.isAdmin(p.getName()))
						Alerts.display("error", "Error", "Invalid player selection");
					else
						player.close();
				}
			
			createTournScene(selectedPlayers);
			
		});
		
		ArrayList<VBox> vbox = new ArrayList<VBox>();
		
		updateTourn.setOnAction(e ->
		{
			//ObservableList<Tournament> selectedTournament, allTournaments;
			Tournament selectedTournament = tournTable.getSelectionModel().getSelectedItem();
		
			ArrayList<Match> list = (ArrayList<Match>) MatchAdmin.getMatches(selectedTournament.getIdTournament());
			int size = list.size();
			
			VBox v0;
			HBox h;
			Label l1, l2, l3,l;
			
			for (Match m : list)
			{
				v0 = new VBox();
				h = new HBox();
				h.setAlignment(Pos.CENTER);
				v0.setAlignment(Pos.CENTER);
				
				int matchid = m.getIdMatch();				
				Game g = GameAdmin.getGame(matchid);
				
				
				
				l1 = new Label(PlayerAdmin.getPlayerName(m.getIdPlayer1()) + "     " + PlayerAdmin.getPlayerName(m.getIdPlayer2()));  
				l2 = new Label("" + g.getScore1());
				l = new Label("   -   ");
				l3 = new Label("" + g.getScore2());
				
				h.getChildren().addAll(l2,l,l3);
				v0.getChildren().addAll(l1,h);
				vbox.add(v0);
			}
			
			for (int i = size; i<7; i++)
			{
				v0 = new VBox();
				v0.setPadding(new Insets(10,20,10,20));
				h = new HBox();
				h.setAlignment(Pos.CENTER);
				v0.setAlignment(Pos.CENTER);
				l1 = new Label("Unknown");
				h.getChildren().add(new Label("Unknwon"));
				v0.getChildren().addAll(l1,h);
				vbox.add(v0);
			}
			
			
			grid.add(vbox.get(0), 0, 0);
			grid.add(vbox.get(1), 0, 2);
			grid.add(vbox.get(2), 0, 4);
			grid.add(vbox.get(3), 0, 6);
			grid.add(vbox.get(4), 1, 1);
			grid.add(vbox.get(5), 1, 5);
			grid.add(vbox.get(6), 2, 3);			

			match.setTitle(selectedTournament.getName());
			match.showAndWait();
		});
		
		deleteTourn.setOnAction(e ->
		{
			String tournName = nameTourn.getText();
			if (TournamentAdmin.isTournament(tournName))
			{
				TournamentAdmin.deleteTournament(tournName);
				Alerts.display("info", "Tournament Deletion", "A tournament has been deleted");
				tournTableLayout.getChildren().clear();
				tournTableLayout.getChildren().addAll(viewTournLabel, TournamentAdmin.createTournTable());
				tournTableLayout.getChildren().addAll(tfsTourn, btnsTourn);
			}
			else
				Alerts.display("error", "Error", "There is no such tournament.");
		});
		
		
		
		
		tournTable.setRowFactory( tv -> {
		    TableRow<Tournament> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (event.getClickCount() == 2 && (! row.isEmpty()) && !PlayerAdmin.isAdmin(usernameText.getText())) {
		        	
		            Tournament t = row.getItem();	            
		            
		            ArrayList<Match> list = (ArrayList<Match>) MatchAdmin.getMatches(t.getIdTournament());
		            grid.getChildren().clear();
		            
		            
		            
		            
		            match.setTitle(t.getName());
		            match.showAndWait();
		        }
		    });
		    return row ;
		});
		
		
		
		
		
		managePlayers.setOnAction(e -> 
		{
			playerTableLayout.getChildren().clear();
			playerTableLayout.getChildren().addAll(playerHeader, playerTable);
			playerTableLayout.getChildren().addAll(tfsPlayer, btnsPlayer);
			window.setScene(playerScene);
		}); 
		
		updatePlayer.setOnAction(e ->
		{
			int id = Integer.parseInt(idPlayer.getText());
			String user = userPlayer.getText();
			String pass = passPlayer.getText();
			String name = namePlayer.getText();
			String right = adminPlayer.getText();
			
			PlayerAdmin.updateUser(id,user,pass,name,right);
			
			refreshPlayerTable();
			playerTableLayout.getChildren().clear();
			playerTableLayout.getChildren().addAll(playerHeader, playerTable);
			playerTableLayout.getChildren().addAll(tfsPlayer, btnsPlayer);
		});
		
		deletePlayer.setOnAction(e -> 
		{
			int id = Integer.parseInt(idPlayer.getText());
			if (!PlayerAdmin.deleteUser(id))
				Alerts.display("error", "Error", "There is no such player.");
			
			refreshPlayerTable();
			playerTableLayout.getChildren().clear();
			playerTableLayout.getChildren().addAll(playerHeader, PlayerAdmin.createPlayerTable());
			playerTableLayout.getChildren().addAll(tfsPlayer, btnsPlayer);
		});
		
		logout.setOnAction(e ->
		{
			window.setScene(logInScene);
		});
		
		back.setOnAction(e ->
		{
			window.setScene(viewScene);
		});
		
		back2.setOnAction(e ->
		{
			window.setScene(viewScene);
		});

		
		logInScene = new Scene(logInLayout, 250, 150);	
		viewScene = new Scene(viewLayout, 200, 200);
		tournScene = new Scene(tournTableLayout, 320,350);
		playerScene = new Scene(playerTableLayout, 522,350);

		window.setTitle("PingPong");
		window.setScene(logInScene);
		window.show();
	}
	
	
	public void createTournScene(ObservableList<Player> list)
	{
		int id = TournamentAdmin.getNextId() - 1;
		
		Match m1 = new Match(MatchAdmin.getNextId(), id, list.get(0).getIdPlayer(), list.get(1).getIdPlayer());
		Game g1 = new Game(GameAdmin.getNextId(), 0, 0, null, MatchAdmin.getNextId() );
		MatchAdmin.addMatch(m1);
		GameAdmin.addGame(g1);
	
		Match m2 = new Match(MatchAdmin.getNextId(), id, list.get(2).getIdPlayer(), list.get(3).getIdPlayer());
		Game g2 = new Game(GameAdmin.getNextId(), 0, 0, null, MatchAdmin.getNextId() );
		MatchAdmin.addMatch(m2);
		GameAdmin.addGame(g2);
		
		Match m3 = new Match(MatchAdmin.getNextId(), id, list.get(4).getIdPlayer(), list.get(5).getIdPlayer());
		Game g3 = new Game(GameAdmin.getNextId(), 0, 0, null, MatchAdmin.getNextId() );
		MatchAdmin.addMatch(m3);
		GameAdmin.addGame(g3);
		
		Match m4 = new Match(MatchAdmin.getNextId(), id, list.get(6).getIdPlayer(), list.get(7).getIdPlayer());
		Game g4 = new Game(GameAdmin.getNextId(), 0, 0, null, MatchAdmin.getNextId() );
		MatchAdmin.addMatch(m4);
		GameAdmin.addGame(g4);
		
	}
	
	public void refreshTournTable()
	{
		tournTable = TournamentAdmin.createTournTable();
	}
	
	public void refreshPlayerTable()
	{
		playerTable = PlayerAdmin.createPlayerTable();
	}

}
