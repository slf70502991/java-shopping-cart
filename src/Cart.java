import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Cart extends Product{
	ProductList productLst = new ProductList();
	List<Product> productList = productLst.getProductList();
	
	List<Product> selectedtList = new ArrayList<Product>();
	
	Set<Product> itemSet = new HashSet<Product>();
	
	Membership membership = new Membership();
	Cart(){
		
	};

	public void shoppingCart(Scanner scanner, BufferedReader br) {
		System.out.println("Shopping Cart\nSelected item list: ");
		printSelectedItem();
		
		String option;
		do{
			System.out.println("PLEASE ENTER YOUR OPTION.\n");
			System.out.println("R: remove item from shopping cart.");
			System.out.println("C: Change the quantity of item selected.");
			System.out.println("T: Order Total");
			System.out.println("P: Print selected items.");
			System.out.println("M: Log in/Sign up");
			System.out.println("Q: quit");
			
			option = scanner.next().toUpperCase();
			switch(option) {
				case "R":
					try {
						removeItem(br);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "C":
					changeItemQantity(scanner);
					break;
				case "T":
					calculateOrderTotal();
					break;
				case "P":
					printSelectedItem();
					break;
				case "M":
					membership.membershipMenu(scanner);
					break;
				case "Q":
					System.out.println("Leave Shopping Cart.");
					break;
				default:
					System.out.println("Please enter a valid option.");
			}
			
		}while(!option.equalsIgnoreCase("Q"));
	}
	
	public void printSelectedItem() {
		
		for(Product p:this.itemSet) {
			System.out.printf("ID: %d |Name: %s | Price: %.2f | Quantity: %d \n",p.productID, p.productName, p.price, p.productQuantity);
		}
	}
	
	public List<Product> getSelectedtList(){
		return selectedtList;
	}
	
	public void setSelectedtList(List<Product> list){
		this.selectedtList = list;
	}
	
	public void addItem(BufferedReader br) throws IOException{
		System.out.println("Please select the item you want to add into the cart");
		String selection = br.readLine();
		String[] items = selection.trim().split("");
		int[] result = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			result[i] = Integer.parseInt(items[i]);
			System.out.println(result[i]);
			Iterator<Product> productIt = productList.iterator();
			while(productIt.hasNext()) {
				Product p = productIt.next();
				if(result[i] == p.productID) {
					if(itemSet.add(p) == false) {
						p.setQuantity(++p.productQuantity);
					}else {
						itemSet.add(p);
					}
					
				}
			}
		}
		printSelectedItem();
	}

	public void removeItem(BufferedReader br) throws IOException {
		System.out.println("Please select the item you want to remove from the cart");
		String products = br.readLine();
		String[] removeStrs = products.trim().split("");
        int[] result = new int[ removeStrs.length ];
	    for (int i = 0; i < removeStrs.length; i++) {
	    	result[i] = Integer.parseInt(removeStrs[i]);
	    	Iterator<Product> removeIter = itemSet.iterator();
	    	while(removeIter.hasNext()) {
	    		Product p = removeIter.next();
	    		if(p.productID == result[i]) {
	    			removeIter.remove();
	    			}
	    		}
			}
	    printSelectedItem();
	}
	
	public void changeItemQantity(Scanner scanner) {
		System.out.println("Please select the item you want to increase/decrease");
		int itemIDtoChange = scanner.nextInt();
		Iterator<Product> it = itemSet.iterator();
		while(it.hasNext()) {
			Product item = it.next();
			if(itemIDtoChange == item.productID) {
				System.out.println("Please enter the quantity of the item: ");
				int quantity = scanner.nextInt();
				if (quantity<0) {
					System.out.println("Quantity should never be less than zero.");
					break;
				}else if(quantity == 0) {
					it.remove();
					break;
				}else {
					item.setQuantity(quantity);
					break;
				}
				
			}else {
				System.out.println("No such element\n");
				break;
			}
		}
		printSelectedItem();
	}
	
	public void checkOut() {
		
	}
	public void calculateOrderTotal() {
		double subTotal = 0f;
		for(Product p:this.itemSet) {
			double itemTotal = p.productQuantity * p.price;
			subTotal += itemTotal;
			System.out.println(subTotal);
		}
		double total = subTotal*1.13;
		System.out.printf("Order Total: %.2f\n\n", total);
	}
}