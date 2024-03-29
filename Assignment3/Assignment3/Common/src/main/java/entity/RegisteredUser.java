package entity;

public class RegisteredUser extends User {
	
	String username;
	String password;
	boolean isAdmin;
	
	public RegisteredUser(){}
	public RegisteredUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = false;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	@Override
	public String toString() {
		return "RegisteredUser [username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	
	

}
