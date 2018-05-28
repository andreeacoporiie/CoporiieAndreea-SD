package daoFactoryImpl;

import dao.GameDAO;
import dao.MatchDAO;
import dao.PlayerDAO;
import dao.TournamentDAO;
import daoFactory.DaoFactory;
import jdbcDAO.JGameDAO;
import jdbcDAO.JMatchDAO;
import jdbcDAO.JPlayerDAO;
import jdbcDAO.JTournamentDAO;

public class JdbcDaoFactory extends DaoFactory {

	@Override
	public GameDAO getGameDAO() {
		return new JGameDAO();
	}

	@Override
	public MatchDAO getMatchDAO() {
		return new JMatchDAO();
	}

	@Override
	public PlayerDAO getPlayerDAO() {
		return new JPlayerDAO();
	}

	@Override
	public TournamentDAO getTournamentDAO() {
		return new JTournamentDAO();
	}

	@Override
	public void closeConnection() {
		
	}
}
