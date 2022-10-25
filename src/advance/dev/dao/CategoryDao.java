package advance.dev.dao;

import java.util.List;

import advance.dev.model.Category;


public interface CategoryDao {
	public void insert(Category category);
	public void update(Category category);
	public void delete(int categoryId);
	public Category find(int categoryId);
	public List<Category> findAll();
}
