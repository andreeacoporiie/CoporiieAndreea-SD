package logic;

import java.util.List;

import dao.GameDAO;
import entity.Game;

public class GameLogic {

	GameDAO DAO;
	
	GameLogic(GameDAO dao){
		this.DAO = dao;
	}
	
	public List<Game> getAllGames(){
	    return DAO.findAll();
	}
	
	public int getNextId()
	{
		List<Game> l =  DAO.findAll();
		if (l == null) return 1;
		if (l.size() > 0){
			Game g = l.get(l.size()-1);
			return g.getIdGame() + 1;
		}
		return 1;
	}
}
