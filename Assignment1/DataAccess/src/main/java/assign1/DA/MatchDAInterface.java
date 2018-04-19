package assign1.DA;

import java.util.List;

import entity.Match;

public interface MatchDAInterface {
	public void insert(Match m);
	public List<Match> findAll();
	public Match findByIdMatch(int id);
	public void removeByMatchId(int id);
	public void removeByTournamentId(int id);
}
