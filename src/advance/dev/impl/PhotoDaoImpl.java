package advance.dev.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import advance.dev.dao.PhotoDao;
import advance.dev.driver.MySQLDriver;
import advance.dev.model.Order_detail;
import advance.dev.model.Photo;

public class PhotoDaoImpl implements PhotoDao{

	@Override
	public void insert(Photo photo) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "INSERT INTO PHOTOS(id, name, url, products_id) VALUES(NULL,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, photo.name);
			stmt.setString(2, photo.url);
			stmt.setInt(3, photo.products_id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Photo photo) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "UPDATE PHOTOS SET name=?, url=?, products_id=? WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, photo.name);
			stmt.setString(2, photo.url);
			stmt.setInt(3, photo.products_id);
			stmt.setInt(4, photo.id);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(int photoId) {
		// TODO Auto-generated method stub
		try {
			Connection conn = MySQLDriver.getInstance().getConnection();
			String sql = "DELETE FROM PHOTOS WHERE ID=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, photoId);
			stmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Photo find(int photoId) {
		// TODO Auto-generated method stub
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM PHOTOS WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, photoId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                int products_id = rs.getInt("products_id");
                return new Photo(id, name, url, products_id);
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Photo> findAll() {
		// TODO Auto-generated method stub
		List<Photo> photoList = new ArrayList<>();
		Connection conn = MySQLDriver.getInstance().getConnection();
		try {
			String sql = "SELECT * FROM PHOTOS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
            	int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                int products_id = rs.getInt("products_id");
                photoList.add(new Photo(id, name, url, products_id)	);
            }
        } catch (SQLException ex) {}
		
		return photoList;
	}

}
