package logic;

import java.util.List;

import dao.PlayerDAO;
import entity.Player;

public class PlayerLogic {

	PlayerDAO DAO;
	
	PlayerLogic(PlayerDAO dao){
		this.DAO = dao;
	}
	
	public List<Player> getAllPlayers(){
	    return DAO.findAll();
	}
	 
	public void addPlayer(Player p){
		DAO.insert(p);
	}
	
	public Player findById(int id)
	{
		return DAO.findById(id);
	}
	public Player findByMail(String mail)
	{
		return DAO.findByMail(mail);
	}
	
	public void updatePlayer(Player p)
	{
		DAO.update(p);
	}
	
	public void deletePlayer(Player p)
	{
		DAO.delete(p);
	}
	
	public int getNextId()
	{
		List<Player> l =  DAO.findAll();
		if (l.size() > 0){
			Player p = l.get(l.size()-1);
			return p.getIdPlayer() + 1;
		}
		return 1;
		}
	 
}
