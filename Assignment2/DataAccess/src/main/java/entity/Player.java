package entity;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

	@Id
    @Column(name = "idPlayer")
	private int idPlayer;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "password")
	private String password;
	 
	@Column(name = "isAdmin")
	private int isAdmin;
	 
	@Column(name = "balance")
	private int balance;
	
	@OneToMany(mappedBy = "player1")
    private List<Matchh> matchesAsPlayer1;

	@OneToMany(mappedBy = "player2")
	private List<Matchh> matchesAsPlayer2;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable( name = "enrollment",
	            joinColumns = {@JoinColumn(name = "idPlayer")},
	            inverseJoinColumns = {@JoinColumn(name = "idTournament")})
	private List<Tournament> tournaments;
	
	public Player(){}
	
	public Player(int idPlayer, String mail, String password, int balance) {
		super();
		this.idPlayer = idPlayer;
		this.mail = mail;
		this.password = password;
		this.balance = balance;
	}
	
	public Player(int idPlayer, String mail, String password) {
		super();
		this.idPlayer = idPlayer;
		this.mail = mail;
		this.password = password;
	}
	
	public Player(int idPlayer, String mail, String password, int isAdmin, int balance) {
		super();
		this.idPlayer = idPlayer;
		this.mail = mail;
		this.password = password;
		this.isAdmin = isAdmin;
		this.balance = balance;
	}

	public int getIdPlayer() {
		return idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Matchh> getMatchesAsPlayer1() {
		return matchesAsPlayer1;
	}

	public void setMatchesAsPlayer1(List<Matchh> matchesAsPlayer1) {
		this.matchesAsPlayer1 = matchesAsPlayer1;
	}

	public List<Matchh> getMatchesAsPlayer2() {
		return matchesAsPlayer2;
	}

	public void setMatchesAsPlayer2(List<Matchh> matchesAsPlayer2) {
		this.matchesAsPlayer2 = matchesAsPlayer2;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public boolean isAdmin()
	{
		if (this.getIsAdmin() == 1) return true;
		return false;
	}
	
	
}
