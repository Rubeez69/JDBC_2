package advance.dev.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import advance.dev.dao.OrderDao;
import advance.dev.driver.MySQLDriver;
import advance.dev.model.Category;
import advance.dev.model.Order;

public class OrderDaoImpl implements OrderDao{

	@Override
	public void insert(Order order) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "INSERT INTO ORDERS(id, code, description, status, created_at, users_id) VALUES(NULL,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, order.code);
			stmt.setString(2, order.description);
			stmt.setString(3, order.status);
			stmt.setString(4, order.created_at);
			stmt.setInt(5, order.users_id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "UPDATE ORDERS SET code=?, DESCRIPTION=?, status=?, created_at=?, users_id=? WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, order.code);
			stmt.setString(2, order.description);
			stmt.setString(3, order.status);
			stmt.setString(4, order.created_at);
			stmt.setInt(5, order.users_id);
			stmt.setInt(6, order.id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(int orderId) {
		// TODO Auto-generated method stub
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			String sql = "DELETE FROM ORDERS WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, orderId);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Order find(int orderId) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM ORDERS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String created_at = rs.getString("created_at");
                int users_id = rs.getInt("users_id");
                
                return new Order(id, code, description, status, created_at, users_id);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		List<Order> orderList = new ArrayList<>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM ORDERS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                String code = rs.getString("code");
                String description = rs.getString("description");
                String status = rs.getString("status");
                String created_at = rs.getString("created_at");
                int users_id = rs.getInt("users_id");
                orderList.add(new Order(id, code, description, status, created_at, users_id));
            }
        } catch (SQLException ex) {}
		
		return orderList;
	}

}
