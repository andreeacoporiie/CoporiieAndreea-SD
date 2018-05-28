package jdbcDAO;

import java.util.List;

import dao.GameDAO;
import entity.Game;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings("restriction")
public class JGameDAO implements GameDAO {

	@Override
	public Game findById(int id) {
		throw new NotImplementedException();
	}

	@Override
	public void insert(Game objectToCreate) {
		throw new NotImplementedException();
		
	}

	@Override
	public void update(Game objectToUpdate) {
		throw new NotImplementedException();
		
	}

	@Override
	public void delete(Game objectToDelete) {
		throw new NotImplementedException();
		
	}

	@Override
	public List<Game> findAll() {
		throw new NotImplementedException();
	}


}
