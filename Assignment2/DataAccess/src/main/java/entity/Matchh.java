package entity;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "matchh")
public class Matchh {
	
	@Id
    @Column(name = "idMatch")
	private int idMatch;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idTournament", nullable=false)
	private Tournament tournament;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPlayer1", nullable=false)
	private Player player1;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPlayer2", nullable=false)
	private Player player2;
	
	 @OneToMany(mappedBy = "match", fetch = FetchType.EAGER)
	private List<Game> games;
	
	public Matchh(){}
	
	public Matchh(int idMatch, Tournament tournament, Player player1, Player player2) {
		super();
		this.idMatch = idMatch;
		this.tournament = tournament;
		this.player1 = player1;
		this.player2 = player2;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
}
