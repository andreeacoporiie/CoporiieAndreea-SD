package dao;

import entity.Tournament;

public interface TournamentDAO extends DAO<Tournament> {

	public Tournament findByStatus(String status);

	public Tournament findByName(String name);
	
}
