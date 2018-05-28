package logic;

import java.util.List;

import dao.TournamentDAO;
import entity.Tournament;

public class TournamentLogic {

	TournamentDAO DAO;
	
	TournamentLogic(TournamentDAO dao){
		this.DAO = dao;
	}
	
	public List<Tournament> getAllTournaments(){
	    return DAO.findAll();
	}
	
	public void addTournament(Tournament t){
		DAO.insert(t);
	}
	
	public void deleteTournament(Tournament t){
		DAO.delete(t);
	}
	
	public void updateTournament(Tournament t){
		DAO.update(t);
	}
	    
	public int getNextId()
	{
		List<Tournament> l =  DAO.findAll();
		if (l == null) return 1;
		if (l.size() > 0){
			Tournament t = l.get(l.size()-1);
			return t.getIdTournament() + 1;
		}
		return 1;
	}

	public Tournament findById(int id) {
		return DAO.findById(id);
	}
	
	public Tournament findByName(String name){
		return DAO.findByName(name);
	}
}
	

