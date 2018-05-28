package entity;
import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
	
	@Id
	@Column(name = "idGame")
	private int idGame;
	
	@Column(name = "score1")
	private int score1;
	
	@Column(name = "score2")
	private int score2;
	
	@ManyToOne
	@JoinColumn(name = "idMatch")
	private Matchh match;
	
	public Game(){}
	
	public Game(int idGame, int score1, int score2, Matchh match) {
		super();
		this.idGame = idGame;
		this.score1 = score1;
		this.score2 = score2;
		this.match = match;
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

	public Matchh getMatch() {
		return match;
	}

	public void setMatch(Matchh match) {
		this.match = match;
	}


	
}
