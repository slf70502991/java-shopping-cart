import java.io.*;
import java.util.Scanner;

public class Membership extends Member{
	
	Membership(){}
	
	SignUp newAccount = new SignUp();
	LogIn logIn = new LogIn();
	
	//Menu for membership system
	public void membershipMenu(Scanner scanner) {
		String option;
		do{
		System.out.println("**************** Log in/Sign in ****************\n");
		System.out.println("PLEASE ENTER YOUR OPTION\n");
		System.out.println("L: Log in");
		System.out.println("S: Sign in");
		System.out.println("O: Log out");
		System.out.println("B: Back to home page");
		
		option = scanner.next().toUpperCase();
		
		switch(option) {
		case "L":
			logIn.logIn(scanner); 
			break;
		case "S":
			try {
				newAccount.signUp(scanner); 
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "O":
			logOut(false);
			break;
		case "B":
			System.out.println("Going to the homepage.");
			break;
		default:
			System.out.println("Please enter a valid option.");
	}
		
		}while(!option.equalsIgnoreCase("B"));
	}

	//Log out: if currently logging in as an username, this method will perform logout function.
	public void logOut(boolean status) {
		if(currentMember.getIsLogIn() == true) {
			currentMember.setIsLogIn(status);
			System.out.println(currentMember.username + " has logged out successfully.");
		}else {
			System.out.println("You have already logged out.");
		}	
	}
}