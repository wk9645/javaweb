package com.wk.jbdc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {

	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/jbdc/bean.xml");
			
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		//单条记录
//		System.out.println(userDao.findById(1));
		//所有记录
//		System.out.println(userDao.findAll());
	
		//插入记录
//		User user = new User("王五","789");
//		userDao.add(user);
		
	}
	
}
