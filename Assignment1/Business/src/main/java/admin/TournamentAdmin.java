package admin;

import java.util.List;

import assign1.DA.*;
import entity.Tournament;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TournamentAdmin extends TournamentDAO {
	private static TournamentAdmin TA = new TournamentAdmin();
	
	@SuppressWarnings("unchecked")
	public static TableView<Tournament> createTournTable()
	{
		TableColumn<Tournament, String> tourId = new TableColumn<>("Id");
		tourId.setVisible(false);
		
		TableColumn<Tournament, String> tourName = new TableColumn<>("Name");
		tourName.setMinWidth(160);
		tourName.setCellValueFactory(new PropertyValueFactory<Tournament, String>("Name"));
		
		TableColumn<Tournament, String> tourWinner = new TableColumn<>("Winner");
		tourWinner.setMinWidth(138);
		tourWinner.setCellValueFactory(new PropertyValueFactory<Tournament, String>("winner"));
		
		TableView<Tournament> tournTable = new TableView<>();
		tournTable.setMaxWidth(300);
		tournTable.setItems(TA.findAllTournaments());
		tournTable.getColumns().addAll(tourId, tourName, tourWinner);
		tournTable.setEditable(false);
	
		return tournTable;
	}

	
	public static Tournament getTournament(int id)
	{
		return TA.findById(id);
	}
	
	public static boolean isTournament(String name)
	{
		Tournament t = TA.findByNameTournament(name);
		if (t != null) 
			return true;
		return false;
	}
	
	public static void addTournament(String name)
	{
		int id = TournamentAdmin.getNextId();
		Tournament t = new Tournament(id,name,"unknown");
		TA.insert(t);
	}
	
	public static void deleteTournament(String name)
	{
		Tournament t = TA.findByNameTournament(name);
		TA.removeByIdTournament(t.getIdTournament());
	}
	
	public static int getNextId()
	{
		List<Tournament> l =  TA.findAll();
		if (l == null) return 1;
		if (l.size() > 0){
			Tournament t = l.get(l.size()-1);
			return t.getIdTournament() + 1;
		}
		return 1;
	}

}
