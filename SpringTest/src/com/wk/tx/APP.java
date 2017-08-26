package com.wk.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {

	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/tx/bean.xml");
			
		UserService userService = (UserService) ac.getBean("userService");
		
		
		User user = new User("赵六","147");
		userService.add(user);
		
		//单条记录
//		System.out.println(userDao.findById(1));
		//所有记录
//		System.out.println(userDao.findAll());
	
		//插入记录
//		User user = new User("王五","789");
//		userDao.add(user);
		
	}
	
}
