package com.wk.test1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

	
	
	//1、创建Bean工厂类，加载Spring容器
	@Test
	public void test1(){
		
		//加载配置文件
		Resource r = new ClassPathResource("com/wk/test1/applicationContext.xml");
		//创建工厂
		BeanFactory bf = new XmlBeanFactory(r);
		User user = (User) bf.getBean("user");
		System.out.println(user);
		
	}
	//2、使用ApplicationContext
	@Test
	public void test2(){
		
		//加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/test1/applicationContext.xml");
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
	
	//创建对象
	@Test
	public void createObject(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/test1/applicationContext.xml");
		User user = (User) ac.getBean("user5");
		System.out.println(user);
	}
	
}
