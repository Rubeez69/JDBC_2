package advance.dev.dao;

import java.util.List;

import advance.dev.model.Product;



public interface ProductDao {
	public void insert(Product product);
	public void update(Product product);
	public void delete(int productId);
	public Product find(int productId);
	public List<Product> findAll();
}
