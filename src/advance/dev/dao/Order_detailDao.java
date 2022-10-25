package advance.dev.dao;

import java.util.List;

import advance.dev.model.Order_detail;


public interface Order_detailDao {
	public void insert(Order_detail order_detail);
	public void update(Order_detail order_detail);
	public void delete(int order_detailId);
	public Order_detail find(int order_detailId);
	public List<Order_detail> findAll();
}
