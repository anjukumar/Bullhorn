package userPack;
public class User {
	String username;
	String password;

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

	public boolean isValidUser(){
		boolean resp=false;
		if(username.equals("anjuk") && (password.equals("0110"))) {
			resp= true;
		}
		return resp;
	}
}
