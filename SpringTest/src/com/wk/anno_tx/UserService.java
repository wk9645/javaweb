package com.wk.anno_tx;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService {
	
	@Resource
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	 
	//指定事务
	@Transactional
	public void add(User user){

		userDao.add(user);
		int i = 1/0;
		userDao.add(user);
	}
	
}
