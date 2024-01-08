import java.io.IOException;
import java.util.Scanner;

public class SignUp extends AccessAccount{
	SignUp(){}
	
	// Register an account
		public void signUp(Scanner scanner) throws IOException  {
			System.out.println("Please enter the username: ");
			String username = scanner.next();
			System.out.println("Please enter the password: ");
			String password = scanner.next();
			
			writeAccount(username, password);
		};
	
}