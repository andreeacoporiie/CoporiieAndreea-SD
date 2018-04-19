package entity;

import java.util.List;

public class Tournament {

	private int idTournament;
	private String name;
	private String winner;
	private List<Match> matches;
	
	public Tournament(){}
	
	public Tournament(int idTournament, String name, String winner) {
		super();
		this.idTournament = idTournament;
		this.name = name;
		this.winner = winner;
	}
	
	public int getIdTournament() {
		return idTournament;
	}
	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	@Override
	public String toString() {
		return "Tournament [idTournament=" + idTournament + ", name=" + name + ", winner=" + winner + "]";
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	
	
	
}
