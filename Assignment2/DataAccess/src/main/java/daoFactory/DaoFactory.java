package daoFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dao.GameDAO;
import dao.MatchDAO;
import dao.PlayerDAO;
import dao.TournamentDAO;
import daoFactoryImpl.HibernateDaoFactory;
import daoFactoryImpl.JdbcDaoFactory;
import org.json.JSONObject;

public abstract class DaoFactory {

	public enum Type {
		HIBERNATE,
		JDBC;
	}


	protected DaoFactory(){

	}

	public static DaoFactory getInstance(Type factoryType) {
		switch (factoryType) {
			case HIBERNATE:
				return new HibernateDaoFactory();
			case JDBC:
				return new JdbcDaoFactory();
			default:
				throw new IllegalArgumentException("Invalid factory");
		}
	}

	 public static DaoFactory getInstance()
	    {
	        String str = new String();
	        String line = new String();

	        try
	        {
	            try (FileReader fileReader = new FileReader("daotype.json");
	                 BufferedReader bufferedReader = new BufferedReader(fileReader))
	            {
	                while ((line = bufferedReader.readLine()) != null)
	                {
	                    str += line;
	                }
	                JSONObject obj = new JSONObject(str);
	                if (obj.get("DaoType").equals("JDBC"))
	                {
	                    return getInstance(Type.JDBC);
	                }
	                if (obj.get("DaoType").equals("HIBERNATE"))
	                {
	                    return getInstance(Type.HIBERNATE);
	                }

	            }
	        }
	        catch (FileNotFoundException ex)
	        {
	             System.out.println("File inexistent");
	        }
	        catch (IOException ex)
	        {
	            System.out.println("Error reading file");
	        }

	        return getInstance(Type.HIBERNATE);
	    }
	
    public abstract GameDAO getGameDAO();

	public abstract MatchDAO getMatchDAO();
	
	public abstract PlayerDAO getPlayerDAO();
	
	public abstract TournamentDAO getTournamentDAO();
	
	public abstract void closeConnection();
}
