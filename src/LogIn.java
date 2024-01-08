import java.util.Scanner;

public class LogIn extends Member{
	
	LogIn(){};
	LogIn(String username, String password, boolean isLogIn){
		super(username, password, isLogIn);
	};
	public boolean getLogIn() {
		return super.getIsLogIn();	
	}
	
	//Login
	public void logIn(Scanner scanner) {
		System.out.println("Please enter the username: ");
		String username = scanner.next();
		System.out.println("Please enter the password: ");
		String password = scanner.next();
		//If the account exists, return true
		boolean status = super.readAccount(username, password);
		if(status) {
			super.setIsLogIn(status);
			System.out.println("Hello, " + username);
			//Set currentMember an stay as a login status
			Member.currentMember.username = username;
			Member.currentMember.password = password;
			Member.currentMember.isLogIn = true;
		}else {
			System.out.println("The username or password is not correct.");
		}
		
	}	

}