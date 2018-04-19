package entity;

public class Match {
	private int idMatch;
	private int idTournament;
	private int idPlayer1;
	private int idPlayer2;
	
	public Match(){}
	
	public Match(int idMatch, int idTournament, int idPlayer1, int idPlayer2) {
		this.idMatch = idMatch;
		this.idTournament = idTournament;
		this.idPlayer1 = idPlayer1;
		this.idPlayer2 = idPlayer2;
	}
	
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public int getIdTournament() {
		return idTournament;
	}
	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}
	public int getIdPlayer1() {
		return idPlayer1;
	}
	public void setIdPlayer1(int idPlayer1) {
		this.idPlayer1 = idPlayer1;
	}
	public int getIdPlayer2() {
		return idPlayer2;
	}
	public void setIdPlayer2(int idPlayer2) {
		this.idPlayer2 = idPlayer2;
	}

	@Override
	public String toString() {
		return "Match [idMatch=" + idMatch + ", idTournament=" + idTournament + ", idPlayer1=" + idPlayer1
				+ ", idPlayer2=" + idPlayer2 + "]";
	}
	
	
	
}
