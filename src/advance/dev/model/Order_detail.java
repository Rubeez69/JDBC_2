package advance.dev.model;

public class Order_detail {
	public int id;
	public int amount;
	public int orders_id;
	public int orders_users_id;
	public int products_id;
	
	
	public Order_detail(int amount, int orders_id, int orders_users_id, int products_id) {
		super();
		this.amount = amount;
		this.orders_id = orders_id;
		this.orders_users_id = orders_users_id;
		this.products_id = products_id;
	}


	public Order_detail(int id, int amount, int orders_id, int orders_users_id, int products_id) {
		super();
		this.id = id;
		this.amount = amount;
		this.orders_id = orders_id;
		this.orders_users_id = orders_users_id;
		this.products_id = products_id;
	}
	
	
}
