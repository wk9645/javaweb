package com.wk.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class APP {

	ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/annotation/bean.xml");
	
	@Test
	public void test(){
		
		
		UserDao dao = (UserDao)ac.getBean("userDao");
		System.out.println(dao.getClass());
		dao.save();
	}
	
}
