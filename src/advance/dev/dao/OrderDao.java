package advance.dev.dao;

import java.util.List;

import advance.dev.model.Order;


public interface OrderDao {
	public void insert(Order order);
	public void update(Order order);
	public void delete(int orderId);
	public Order find(int orderId);
	public List<Order> findAll();
}
