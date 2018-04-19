package assign1.DA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Tournament;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TournamentDAO implements TournamentDAInterface {

	public void insert(Tournament t) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO tournament (idTournament, name, winner) VALUES (?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, t.getIdTournament());
			statement.setString(2, t.getName());
			statement.setString(3, t.getWinner());
			
			statement.executeUpdate();
 
		} catch (SQLException e) {
			System.out.println("Tournament:insert" + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	public List<Tournament> findAll(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM tournament";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
        	System.out.println("Tourn:findall " + e.getMessage());
        } catch (IllegalArgumentException e) {
        	  System.out.println("Tourn:findall " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
	}
	
	public ObservableList<Tournament> findAllTournaments(){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ObservableList<Tournament> list = FXCollections.observableArrayList();
		
		String query = "SELECT * FROM tournament";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
				Tournament instance = new Tournament();
				instance.setIdTournament((Integer)resultSet.getObject("idTournament"));
				instance.setName((String)resultSet.getObject("name"));
				instance.setWinner((String)resultSet.getObject("winner"));
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
	
	public Tournament findById(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM tournament WHERE idTournament=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			System.out.println("Tournament: findbytourid " + e.getMessage());
		} catch (Exception e) {
			return null;
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public Tournament findByNameTournament(String name){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM tournament WHERE name=?";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			System.out.println("Tournament: findbytourid " + e.getMessage());
		} catch (Exception e) {
			return null;
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public void removeByIdTournament(int id){
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "DELETE FROM tournament WHERE idTournament=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, id);
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Tournament: remove " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	
	public void updateTournament(Tournament t) {
		 Connection connection = null;
	     PreparedStatement statement = null;
	     String query = "UPDATE tournament SET name=?, winner=? WHERE idTournament=?";
	     try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, t.getName());
				statement.setString(2, t.getWinner());
				statement.setInt(3, t.getIdTournament());
				statement.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Tournament: update " + e.getMessage());
			} finally {
				ConnectionFactory.close(statement);
				ConnectionFactory.close(connection);
			}
	}
	
	private List<Tournament> createObjects(ResultSet resultSet) {
		List<Tournament> list = new ArrayList<Tournament>();

		try {
			while (resultSet.next()) {
				Tournament instance = new Tournament();
				instance.setIdTournament((Integer)resultSet.getObject("idTournament"));
				instance.setName((String)resultSet.getObject("name"));
				instance.setWinner((String)resultSet.getObject("winner"));
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
