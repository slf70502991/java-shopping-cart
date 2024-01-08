public class Product{
	protected int productID;
	protected String productName;
	protected double price;
	protected int productQuantity;
	Product(){};
	Product(int productID, String productName, double price, int productQuantity){
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.productQuantity = productQuantity;
		
	};
	public void setQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
}