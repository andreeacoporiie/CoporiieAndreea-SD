package assign1.DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Game;

public class GameDAO implements GameDAInterface {

	public void insert(Game g) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO game (idGame, score1, score2, winner, idMatch) VALUES (?,?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, g.getIdGame());
			statement.setInt(2, g.getScore1());
			statement.setInt(3, g.getScore2());
			statement.setString(4, g.getWinner());
			statement.setInt(5, g.getIdMatch());
			
			statement.executeUpdate();
 
		} catch (SQLException e) {
			System.out.println("GameDAO:insert" + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public List<Game> findAll(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM game";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
        	System.out.println("Game:findall " + e.getMessage());
        } catch (IllegalArgumentException e) {
        	  System.out.println("Game:findall " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
	}
	
	public Game findByIdGame(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM game WHERE idGame=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			System.out.println("Gmae:findByIdGame " + e.getMessage());
		} catch (Exception e) {
			return null;
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public Game findByIdMatch(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM game WHERE idMatch=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			System.out.println("Game:findByIdMatch " + e.getMessage());
		} catch (Exception e) {
			return null;
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	
	public void removeByIdGame(int id){
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "DELETE FROM game WHERE idGame=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Game:removebyid " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	public void removeByIdMatch(int id) {
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "DELETE FROM game WHERE idMatch=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Game: removebymatchid " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	public void updateGame(Game g) {
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "UPDATE game SET score1=?, score2=?, winner=? WHERE idGame=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, g.getScore1());
				statement.setInt(2, g.getScore2());
				statement.setString(3, g.getWinner());
				statement.setInt(4, g.getIdGame());
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Game: update " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	private List<Game> createObjects(ResultSet resultSet) {
		List<Game> list = new ArrayList<Game>();

		try {
			while (resultSet.next()) {
				Game instance = new Game();
				instance.setIdGame((Integer)resultSet.getObject("idGame"));
				instance.setScore1((Integer)resultSet.getObject("score1"));
				instance.setScore2((Integer)resultSet.getObject("score2"));
				instance.setWinner((String)resultSet.getObject("winner"));
				instance.setIdMatch((Integer)resultSet.getObject("idMatch"));
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
