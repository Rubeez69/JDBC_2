package advance.dev.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDriver {
	final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    final String USER = "root";
    final String PASS = "";
    private static MySQLDriver instance;
    
    private MySQLDriver() {}
    
	public static MySQLDriver getInstance() {
		if(instance == null) instance = new MySQLDriver();
		return instance;
	}
    public Connection getConnection() {
    	try {
    		return DriverManager.getConnection(DB_URL, USER, PASS);
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return null;
    }
}
