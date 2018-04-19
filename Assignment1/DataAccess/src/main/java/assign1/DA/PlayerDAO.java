package assign1.DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import entity.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlayerDAO implements PlayerDAInterface {

	public void insert(Player p) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO player (idPlayer, mail, password, name, isAdmin) VALUES (?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, p.getIdPlayer());
			statement.setString(2, p.getMail());
			statement.setString(3, p.getPassword());
			statement.setString(4, p.getName());
			statement.setInt(5, p.getIsAdmin());
			
			statement.executeUpdate();
 
		} catch (SQLException e) {
			System.out.println("PlayerDAO:insert" + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public List<Player> findAll(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM player";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
        	System.out.println("Match:findall " + e.getMessage());
        } catch (IllegalArgumentException e) {
        	  System.out.println("Match:findall " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
	}
	
	public ObservableList<Player> findAllPlayers(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ObservableList<Player> list = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM player";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
				Player instance = new Player();
				instance.setIdPlayer((Integer)resultSet.getObject("idPlayer"));
				instance.setMail((String)resultSet.getObject("mail"));
				instance.setPassword((String)resultSet.getObject("password"));
				instance.setName((String)resultSet.getObject("name"));
				instance.setIsAdmin((Integer)resultSet.getObject("isAdmin"));
				list.add(instance);
            }
        } catch (SQLException e) {
        	System.out.println("Tourn:findall " + e.getMessage());
        } catch (IllegalArgumentException e) {
        	  System.out.println("Tourn:findall " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return list;
	}
	
	public Player findByIdPlayer(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM player WHERE idPlayer=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			Player instance = new Player();
			if (resultSet.next())
			{
				instance.setIdPlayer((Integer)resultSet.getObject("idPlayer"));
				instance.setMail((String)resultSet.getObject("mail"));
				instance.setPassword((String)resultSet.getObject("password"));
				instance.setName((String)resultSet.getObject("name"));
				instance.setIsAdmin((Integer)resultSet.getObject("isAdmin"));
			}
			return instance;
		} catch (SQLException e) {
			System.out.println("Match:findByIdPlayer " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public Player findByMail(String mail){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM player WHERE mail=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, mail);
			resultSet = statement.executeQuery();
			Player instance = new Player();
			if (resultSet.next())
			{
				instance.setIdPlayer((Integer)resultSet.getObject("idPlayer"));
				instance.setMail((String)resultSet.getObject("mail"));
				instance.setPassword((String)resultSet.getObject("password"));
				instance.setName((String)resultSet.getObject("name"));
				instance.setIsAdmin((Integer)resultSet.getObject("isAdmin"));
			}
			return instance;
		} catch (SQLException e) {
			System.out.println("Match:findByIdPlayer " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public void removeByIdPlayer(int id){
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "DELETE FROM player WHERE idPlayer=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Match:removeByMatchId " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	public void updatePlayer(Player p) {
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "UPDATE player SET mail=?, password=?, name=?, isAdmin=? WHERE idPlayer=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, p.getMail());
				statement.setString(2, p.getPassword());
				statement.setString(3, p.getName());
				statement.setInt(4, p.getIsAdmin());
				statement.setInt(5, p.getIdPlayer());
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Match: update " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	private List<Player> createObjects(ResultSet resultSet) {
		List<Player> list = new ArrayList<Player>();

		try {
			while (resultSet.next()) {
				Player instance = new Player();
				instance.setIdPlayer((Integer)resultSet.getObject("idPlayer"));
				instance.setMail((String)resultSet.getObject("mail"));
				instance.setPassword((String)resultSet.getObject("password"));
				instance.setName((String)resultSet.getObject("name"));
				instance.setIsAdmin((Integer)resultSet.getObject("isAdmin"));
				list.add(instance);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	
	
}
