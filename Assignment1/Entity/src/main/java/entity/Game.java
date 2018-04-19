package entity;

public class Game {
	private int idGame;
	private int score1;
	private int score2;
	private String winner;
	private int idMatch;
	
	public Game(){}
	
	public Game(int idGame, int score1, int score2, String winner, int idMatch) {
		super();
		this.idGame = idGame;
		this.score1 = score1;
		this.score2 = score2;
		this.winner = winner;
		this.idMatch = idMatch;
	}
	
	public Game(int idGame, int idMatch) {
		super();
		this.idGame = idGame;
		this.score1 = 0;
		this.score2 = 0;
		this.idMatch = idMatch;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	
	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Game [idGame=" + idGame + ", score1=" + score1 + ", score2=" + score2 + ", winner=" + winner
				+ ", idMatch=" + idMatch + "]";
	}
	
	
}
