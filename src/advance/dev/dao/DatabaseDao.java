package advance.dev.dao;

public abstract class DatabaseDao {
	private static DatabaseDao instance;
	
	public static void init(DatabaseDao _instance) {
		instance = _instance;
	}
	
	public static DatabaseDao getInstance() {
		return instance;
	}
	
	public abstract UserDao getUserDao();
}
