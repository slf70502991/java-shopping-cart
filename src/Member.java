
public class Member extends AccessAccount{
	//For recording the current login user.
	static Member currentMember = new Member();
	
	String username;
	String password;
	String encrytedPass;
	boolean isLogIn = false;
	
	Member(){}
	Member(String username, String password, boolean isLogIn){
		this.username = username;
		this.password = password;
		this.isLogIn = isLogIn;
	}
	
	
	public boolean getIsLogIn() {
		return isLogIn;
	}
	public void setIsLogIn(boolean status) {
		this.isLogIn = status;
	}

}