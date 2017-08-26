package com.wk.object_relationship;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



//@Component
@Service
public class UserService {

	@Resource
	private UserDao userDao;
	public void save(){
		
		userDao.save();
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
