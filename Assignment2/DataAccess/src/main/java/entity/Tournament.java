package entity;
import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {

	@Id
    @Column(name="idTournament")
	private int idTournament;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private String status;
	
	@Column(name="fee")
	private int fee;
	
	@Column(name="prize")
	private int prize;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "tournament")
	private List<Matchh> matches;
	
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tournaments")
    private List<Player> enrolledPlayers;
	
	
	public Tournament(){}
	
	public Tournament(int idTournament, String name, String status, int fee,int prize) {
		super();
		this.idTournament = idTournament;
		this.name = name;
		this.status = status;
		this.fee = fee;
		this.prize = prize;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public List<Matchh> getMatches() {
		return matches;
	}

	public void setMatches(List<Matchh> matches) {
		this.matches = matches;
	}

	public List<Player> getEnrolledPlayers() {
		return enrolledPlayers;
	}

	public void setEnrolledPlayers(List<Player> enrolledPlayers) {
		this.enrolledPlayers = enrolledPlayers;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}
	

	
}
