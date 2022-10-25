package advance.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import advance.dev.dao.Database;
import advance.dev.dao.DatabaseDao;
import advance.dev.dao.UserDao;
import advance.dev.driver.MySQLDriver;
import advance.dev.impl.UserDaoImpl;
import advance.dev.model.User;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseDao.init(new Database());
		
		UserDao userDao = DatabaseDao.getInstance().getUserDao();
//		insertUsers(userDao);
		userDao.update(new User(2, "bruh@gmail.com", "42323", "user"));
		userDao.delete(2);
//		List<User> userList = userDao.findAll();
//		for (User user : userList) {
//			System.out.println(user.email);
//		}
		
		User user = userDao.find(6);
		System.out.println(user.email);
	}

	private static void insertUsers(UserDao userDao) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			User user = new User("email" + i + "@gmail.com", "123", "user");
			userDao.insert(user);
		}
	}

	private static void select(Connection conn) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM USERS WHERE ID > ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                System.out.format("%d:%s:%s:%s", id, email, password, role).println();
            }
        } catch (SQLException ex) {}
	}

	private static void delete(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM USERS WHERE ID=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, 1);
		stmt.execute();
	}

	private static void update(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	private static void insert(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO USERS(id, email, password, role) VALUES(NULL,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "an@gmail.com");
		stmt.setString(2, "123321");
		stmt.setString(3, "admin");
		stmt.execute();
	}
	
	

}
