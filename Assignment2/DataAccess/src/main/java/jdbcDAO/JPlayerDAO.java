package jdbcDAO;

import java.util.List;

import dao.PlayerDAO;
import entity.Player;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@SuppressWarnings("restriction")
public class JPlayerDAO implements PlayerDAO {

	@Override
	public Player findById(int id) {
		throw new NotImplementedException();
	}

	@Override
	public void insert(Player objectToCreate) {
		throw new NotImplementedException();
		
	}

	@Override
	public void update(Player objectToUpdate) {
		throw new NotImplementedException();
		
	}

	@Override
	public void delete(Player objectToDelete) {
		throw new NotImplementedException();
		
	}

	@Override
	public List<Player> findAll() {
		throw new NotImplementedException();
	}

	@Override
	public Player findByMail(String mail) {
		throw new NotImplementedException();
	}


	
}
