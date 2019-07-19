package persistence.domain;

public class ProjectAccount {
	
	private int id;
	private String userName;
	private String Password;
	private String email;
	
	public ProjectAccount(String userName, String password, String email, int id) {
		super();
		this.userName = userName;
		Password = password;
		this.email = email;
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
