import java.util.ArrayList;
import java.util.List;

public class ProductList extends Product{
	Product p1 = new Product(1, "ASUS",300f, 1);
	Product p2 = new Product(2, "Acer",250f, 1);
	Product p3 = new Product(3, "Lenova",350f, 1);
	Product p4 = new Product(4, "Apple",400f, 1);
	Product p5 = new Product(5, "MSI",200f, 1);
	
	List<Product> productList = new ArrayList<Product>();
	
	ProductList(){
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
		productList.add(p5);
	}
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public void printProduct() {
		for(Product p:productList) {
			System.out.printf("ID: %d | Name: %s | Price: %.2f | Quantity: %d \n", p.productID, p.productName, p.price, p.productQuantity);
		}
	}
}