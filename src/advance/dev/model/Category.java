package advance.dev.model;

public class Category {
	public int id;
	public String name;
	public String description;
	
	
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	public Category(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
}
