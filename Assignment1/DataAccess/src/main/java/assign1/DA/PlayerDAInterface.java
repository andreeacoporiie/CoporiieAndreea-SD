package assign1.DA;

import java.util.List;

import entity.Player;

public interface PlayerDAInterface {

	public void insert(Player p);
	public List<Player> findAll();
	public Player findByIdPlayer(int id);
	public Player findByMail(String mail);
	public void removeByIdPlayer(int id);
	public void updatePlayer(Player p);
	
}
