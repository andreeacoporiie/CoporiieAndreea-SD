package assign1.DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Match;

public class MatchDAO implements MatchDAInterface {

	public void insert(Match m) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO pingpong.match (idMatch, idTournament, idPlayer1, idPlayer2) VALUES (?,?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, m.getIdMatch());
			statement.setInt(2, m.getIdTournament());
			statement.setInt(3, m.getIdPlayer1());
			statement.setInt(4, m.getIdPlayer2());
			
			statement.executeUpdate();
 
		} catch (SQLException e) {
			System.out.println("MatchDAO:insert" + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public List<Match> findAll(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM pingpong.match";
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
	
	public Match findByIdMatch(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM match WHERE idMatch=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			System.out.println("Match:findByIdMatch " + e.getMessage());
		} catch (Exception e) {
			return null;
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<Match> findByIdTournament(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM match WHERE idTournament=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			System.out.println("Match:findByIdTourn " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public List<Match> findByIdPlayer(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM match WHERE idPlayer1=? OR idPlayer2=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setInt(2, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			System.out.println("Match:findByIdPlayer " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public void removeByMatchId(int id){
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "DELETE FROM match WHERE idMatch=?";
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
	
	public void removeByTournamentId(int id){
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "DELETE FROM match WHERE idTournament=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Match:removeByTournamentId " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	public void updateMatch(Match m) {
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "UPDATE match SET idPlayer1=?, idPlayer2=? WHERE idMatch=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, m.getIdPlayer1());
				statement.setInt(2, m.getIdPlayer2());
				statement.setInt(3, m.getIdMatch());
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Match: update " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	private List<Match> createObjects(ResultSet resultSet) {
		List<Match> list = new ArrayList<Match>();

		try {
			while (resultSet.next()) {
				Match instance = new Match();
				instance.setIdMatch((Integer)resultSet.getObject("idMatch"));
				instance.setIdPlayer1((Integer)resultSet.getObject("idPlayer1"));
				instance.setIdPlayer2((Integer)resultSet.getObject("idPlayer2"));
				instance.setIdTournament((Integer)resultSet.getObject("IdTournament"));
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
