package com.wk.service;

import com.wk.dao.UserDao;

public class UserService {

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void save(){
		userDao.save();
	}
}
