package assign1.DA;

import java.util.List;

import entity.Tournament;

public interface TournamentDAInterface {
	public void insert(Tournament t);
	public List<Tournament> findAll();
	public Tournament findById(int id);
	public void removeByIdTournament(int id);
}
