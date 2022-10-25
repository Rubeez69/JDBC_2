package advance.dev.model;

public class Product {
	public int id;
	public String name;
	public String desc;
	public float price;
	public int quantity;
	public int categories_id;
	
	
	public Product(String name, String desc, float price, int quantity, int categories_id) {
		super();
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
		this.categories_id = categories_id;
	}


	public Product(int id, String name, String desc, float price, int quantity, int categories_id) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
		this.categories_id = categories_id;
	}
	
	

}
