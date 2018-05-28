package daoFactoryImpl;


import dao.GameDAO;
import dao.MatchDAO;
import dao.PlayerDAO;
import dao.TournamentDAO;
import daoFactory.DaoFactory;
import hibernateDAO.HGameDAO;
import hibernateDAO.HMatchDAO;
import hibernateDAO.HPlayerDAO;
import hibernateDAO.HTournamentDAO;

public class HibernateDaoFactory extends DaoFactory {
	 
	@Override
	public GameDAO getGameDAO() {
		return new HGameDAO();
	}

	@Override
	public MatchDAO getMatchDAO() {
		return new HMatchDAO();
	}

	@Override
	public PlayerDAO getPlayerDAO() {
		return new HPlayerDAO();
	}

	@Override
	public TournamentDAO getTournamentDAO() {
		return new HTournamentDAO();
	}

	@Override
	public void closeConnection() {
		
	}

}
