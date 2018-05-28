package logic;

import java.util.List;

import dao.MatchDAO;
import entity.Matchh;

public class MatchLogic {

	MatchDAO DAO;
	
	MatchLogic(MatchDAO dao){
		this.DAO = dao;
	}
	
	public List<Matchh> getAllMatches(){
	    return DAO.findAll();
	}
	
	public int getNextId()
	{
		List<Matchh> l =  DAO.findAll();
		if (l == null) return 1;
		if (l.size() > 0){
			Matchh m = l.get(l.size()-1);
			return m.getIdMatch() + 1;
		}
		return 1;
	}
}
