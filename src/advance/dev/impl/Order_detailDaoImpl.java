package advance.dev.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import advance.dev.dao.Order_detailDao;
import advance.dev.driver.MySQLDriver;
import advance.dev.model.Order_detail;


public class Order_detailDaoImpl implements Order_detailDao{

	@Override
	public void insert(Order_detail order_detail) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "INSERT INTO ORDER_DETAILS(id, amount, orders_id, orders_users_id, products_id) VALUES(NULL,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, order_detail.amount);
			stmt.setInt(2, order_detail.orders_id);
			stmt.setInt(3, order_detail.orders_users_id);
			stmt.setInt(4, order_detail.products_id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Order_detail order_detail) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "UPDATE ORDER_DETAILS SET amount=?, orders_id=?, orders_users_id=?, products_id=? WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, order_detail.amount);
			stmt.setInt(2, order_detail.orders_id);
			stmt.setInt(3, order_detail.orders_users_id);
			stmt.setInt(4, order_detail.products_id);
			stmt.setInt(5, order_detail.id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(int order_detailId) {
		// TODO Auto-generated method stub
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			String sql = "DELETE FROM ORDER_DETAILS WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, order_detailId);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Order_detail find(int order_detailId) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM ORDER_DETAILS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, order_detailId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                int orders_id = rs.getInt("orders_id");
                int orders_users_id = rs.getInt("orders_users_id");
                int products_id = rs.getInt("products_id");
                return new Order_detail(id, amount, orders_id, orders_users_id, products_id);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Order_detail> findAll() {
		// TODO Auto-generated method stub
		List<Order_detail> order_detailList = new ArrayList<>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM ORDER_DETAILS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                int amount = rs.getInt("amount");
                int orders_id = rs.getInt("orders_id");
                int orders_users_id = rs.getInt("orders_users_id");
                int products_id = rs.getInt("products_id");
                order_detailList.add(new Order_detail(id, amount, orders_id, orders_users_id, products_id));
            }
        } catch (SQLException ex) {}
		
		return order_detailList;
	}

}
