package entity;

public class Player {

	private int idPlayer;
	private String mail;
	private String password;
	private String name;
	private int isAdmin;
	
	public Player(){}
	
	public Player(int idPlayer, String mail, String password, String name) {
		super();
		this.idPlayer = idPlayer;
		this.mail = mail;
		this.password = password;
		this.name = name;
	}
	
	public Player(int idPlayer, String mail, String password, String name, int isAdmin) {
		super();
		this.idPlayer = idPlayer;
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.isAdmin = isAdmin;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Player [idPlayer=" + idPlayer + ", mail=" + mail + ", password=" + password + ", name=" + name
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
	
}
