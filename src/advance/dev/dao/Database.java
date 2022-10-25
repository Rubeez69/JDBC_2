package advance.dev.dao;

import advance.dev.impl.UserDaoImpl;

public class Database extends DatabaseDao {
	
	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new UserDaoImpl();
	}

}
