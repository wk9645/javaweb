package com.wk.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {

	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/tx/bean.xml");
			
		UserService userService = (UserService) ac.getBean("userService");
		
		
		User user = new User("����","147");
		userService.add(user);
		
		//������¼
//		System.out.println(userDao.findById(1));
		//���м�¼
//		System.out.println(userDao.findAll());
	
		//�����¼
//		User user = new User("����","789");
//		userDao.add(user);
		
	}
	
}
