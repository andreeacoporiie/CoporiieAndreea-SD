package admin;


import java.util.List;

import assign1.DA.*;
import entity.Player;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlayerAdmin extends PlayerDAO {
	private static PlayerAdmin PA = new PlayerAdmin();
	
	
	public static boolean validateLogin(String mail, String pass)
	{
		Player p = PA.findByMail(mail); 	
		if (p!=null)
		{
			if (p.getPassword().equals(pass))
			{
				return true;
			}
		} 
		return false;
	}
	
	public static boolean isUser(String mail)
	{
		Player p = PA.findByMail(mail);	
		if (p != null)
				return true;
		return false;
	}
	
	public static boolean isAdmin(String mail)
	{
		Player p = PA.findByMail(mail); 
		if (p != null && p.getIsAdmin() == 1)
			return true;
		return false;
	}
	
	public static void addUser(String user, String pass, String name)
	{
		int id = PlayerAdmin.getNextId();
		Player p = new Player(id,user,pass,name,0);
		PA.insert(p);
	}
	
	public static int getNextId()
	{
		List<Player> l =  PA.findAll();
		if (l.size() > 0){
			Player p = l.get(l.size()-1);
			return p.getIdPlayer() + 1;
		}
		return 1;
	}
	
	public static boolean deleteUser(int id)
	{
		Player p = PA.findByIdPlayer(id);
		if (id > 0 && p != null)
		{
			PA.removeByIdPlayer(id);
			return true;
		}
		return false;
	}
	
	public static void updateUser(int id, String user, String pass, String name, String right)
	{
		Player p = PA.findByIdPlayer(id);
		if (!isUser(user) && !user.equals(""))
			p.setMail(user);
		if (!pass.equals(""))
			p.setPassword(pass);
		if (!name.equals(""))
			p.setName(name);
		if (!right.equals(""))
		{
			int r = Integer.parseInt(right);
			if (r == 0 || r == 1)
				p.setIsAdmin(r);
		}	
		PA.updatePlayer(p);
	}
	
	@SuppressWarnings("unchecked")
	public static TableView<Player> createPlayerTable()
	{
		TableColumn<Player, String> playerid = new TableColumn<>("Id");
		playerid.setMinWidth(100);
		playerid.setCellValueFactory(new PropertyValueFactory<Player, String>("idPlayer"));
		
		TableColumn<Player, String> playeruser = new TableColumn<>("Username");
		playeruser.setMinWidth(200);
		playeruser.setCellValueFactory(new PropertyValueFactory<Player, String>("mail"));
		
		TableColumn<Player, String> playerpass = new TableColumn<>("Password");
		playerpass.setVisible(false);
		
		TableColumn<Player, String> playername = new TableColumn<>("Name");
		playername.setMinWidth(100);
		playername.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		
		TableColumn<Player, String> playeradmin = new TableColumn<>("Admin Rights");
		playeradmin.setMinWidth(100);
		playeradmin.setCellValueFactory(new PropertyValueFactory<Player, String>("isAdmin"));
		
		TableView<Player> playerTable = new TableView<>();
		playerTable.setMaxWidth(504);
		playerTable.setItems(PA.findAllPlayers());
		playerTable.getColumns().addAll(playerid,playeruser,playerpass,playername,playeradmin);
		playerTable.setEditable(false);
	
		return playerTable;
	}

	public static String getPlayerName(int id) {
		Player p = PA.findByIdPlayer(id);
		return p.getName();
	}
}
