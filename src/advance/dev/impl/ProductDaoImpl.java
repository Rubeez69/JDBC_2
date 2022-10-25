package advance.dev.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import advance.dev.dao.ProductDao;
import advance.dev.driver.MySQLDriver;
import advance.dev.model.Product;
import advance.dev.model.User;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "INSERT INTO PRODUCTS(id, name, desc, price, quantity, categories_id) VALUES(NULL,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.name);
			stmt.setString(2, product.desc);
			stmt.setFloat(3, product.price);
			stmt.setInt(4, product.quantity);
			stmt.setInt(5, product.categories_id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "UPDATE PRODUCTS SET NAME=?, DESC=?, PRICE=?, QUANTITY =?, CATEGORIES_ID =? WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.name);
			stmt.setString(2, product.desc);
			stmt.setFloat(3, product.price);
			stmt.setInt(4, product.quantity);
			stmt.setInt(5, product.categories_id);
			stmt.setInt(6, product.id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			String sql = "DELETE FROM PRODUCTS WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productId);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Product find(int productId) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM PRODUCTS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                int categories_id = rs.getInt("categories_id");
                return new Product(id, name, desc, price, quantity, categories_id);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM PRODUCTS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("desc");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                int categories_id = rs.getInt("categories_id");
                productList.add(new Product(id, name, desc, price, quantity, categories_id));
            }
        } catch (SQLException ex) {}
		
		return productList;
	}

}
