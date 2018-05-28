package dao;

import entity.Player;

public interface PlayerDAO extends DAO<Player> {

	public Player findByMail(String mail);
	
}
