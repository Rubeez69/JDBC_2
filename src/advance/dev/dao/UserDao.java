package advance.dev.dao;

import java.util.List;

import advance.dev.model.User;

public interface UserDao {
	public void insert(User user);
	public void update(User user);
	public void delete(int userId);
	public User find(int userId);
	public List<User> findAll();
}
