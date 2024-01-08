import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// This class includes the method used in home menu.
public class Home{

	ProductList productLst = new ProductList();
	//Get available product list.
	List<Product> productList = productLst.getProductList();
	
	
	Cart cart = new Cart();
	//The list for storing selected item
	List<Product> selectedtList = cart.getSelectedtList();
	
	
	Home(){};
	
	//Print out the available product
	public void printPrductList() {
		productLst.printProduct();
	}
	
	//Add selected item into shopping cart
	public void addItem(BufferedReader br) throws IOException {
		cart.addItem(br);
		
	    }
	    
	//Remove selected item
	public void removeItem(BufferedReader br) throws IOException {
		cart.removeItem(br);
	
	}
	
	//Go to shopping cart
	public void goToCart(Scanner scanner, BufferedReader br) {
		cart.shoppingCart(scanner, br);
	}
}