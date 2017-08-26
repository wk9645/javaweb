package com.wk.tx;

public class UserService {
	
	
	
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void add(User user){

		userDao.add(user);
		int i = 1/0;
		userDao.add(user);
	}
	
}
