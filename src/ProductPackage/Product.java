package ProductPackage;

public class Product {

	private String name;
	private String category;
	private String description;
	private double price;
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(String name, String category, String description, double price, int quanitity) {
		
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Product(String name, double price, String category, String description) {

		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	public Product(String name, double price){

		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





}
