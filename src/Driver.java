import java.util.Scanner;
import java.awt.SystemColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver{
	public static void main ( String[] args) {
		Home h = new Home();
		Membership membership = new Membership();
		
		//Home menu
		while(true) {
		System.out.println("********************* Welcome to Laptop Store *********************");
		System.out.println("********************* We're selling ********************* \n");
		
		h.printPrductList();
		System.out.println();
		System.out.println("PLEASE ENTER YOUR OPTION\n");
		System.out.println("A: add new item into shopping cart");
		System.out.println("R: remove item from shopping cart");
		System.out.println("S: Go to the cart");
		System.out.println("M: Log in/Sign up");
		System.out.println("Q: quit");
		
		Scanner scanner = new Scanner(System.in); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String option = scanner.next().toUpperCase();
		
		
		//A: add new item into shopping cart
		//R: remove items from shopping cart
		//S: Go to Shopping Cart
		//M: Go to membership page.
		//Q: quit
		
			switch(option) {
			case "A":
				try {
					h.addItem(br);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "R":
				try {
					h.removeItem(br);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "S":
				h.goToCart(scanner, br);
				break;
			case "M":
				membership.membershipMenu(scanner);
				break;
			case "Q": 
				System.out.println("Goodbye");
				System.exit(0);
			}
		}
		
	}
}