package com.wk.jbdc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP {

	
	
	public static void main(String[] args) {
		
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/jbdc/bean.xml");
			
		UserDao userDao = (UserDao) ac.getBean("userDao");
		
		//������¼
//		System.out.println(userDao.findById(1));
		//���м�¼
//		System.out.println(userDao.findAll());
	
		//�����¼
//		User user = new User("����","789");
//		userDao.add(user);
		
	}
	
}
