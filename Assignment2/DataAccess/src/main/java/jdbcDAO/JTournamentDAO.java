package jdbcDAO;

import java.util.List;

import dao.TournamentDAO;
import entity.Tournament;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings("restriction")
public class JTournamentDAO implements TournamentDAO {

	@Override
	public Tournament findById(int id) {
		throw new NotImplementedException();
	}

	@Override
	public void insert(Tournament objectToCreate) {
		throw new NotImplementedException();
		
	}

	@Override
	public void update(Tournament objectToUpdate) {
		throw new NotImplementedException();
		
	}

	@Override
	public void delete(Tournament objectToDelete) {
		throw new NotImplementedException();
		
	}

	@Override
	public List<Tournament> findAll() {
		throw new NotImplementedException();
	}

	@Override
	public Tournament findByStatus(String name) {
		throw new NotImplementedException();
	}

	@Override
	public Tournament findByName(String name) {
		throw new NotImplementedException();
	}

	
	
}
