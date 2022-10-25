package advance.dev.model;

public class Order {
	public int id;
	public String code;
	public String description;
	public String status;
	public String created_at;
	public int users_id;
	
	
	
	public Order(String code, String description, String status, String created_at, int users_id) {
		super();
		this.code = code;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.users_id = users_id;
	}



	public Order(int id, String code, String description, String status, String created_at, int users_id) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.users_id = users_id;
	}
	
	
}
	
	
