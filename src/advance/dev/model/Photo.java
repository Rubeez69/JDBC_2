package advance.dev.model;

public class Photo {
	public int id;
	public String name;
	public String url;
	public int products_id;
	
	
	public Photo(String name, String url, int products_id) {
		super();
		this.name = name;
		this.url = url;
		this.products_id = products_id;
	}

	public Photo(int id, String name, String url, int products_id) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.products_id = products_id;
	}
	
	
}
