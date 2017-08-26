package com.wk.test1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

	
	
	//1������Bean�����࣬����Spring����
	@Test
	public void test1(){
		
		//���������ļ�
		Resource r = new ClassPathResource("com/wk/test1/applicationContext.xml");
		//��������
		BeanFactory bf = new XmlBeanFactory(r);
		User user = (User) bf.getBean("user");
		System.out.println(user);
		
	}
	//2��ʹ��ApplicationContext
	@Test
	public void test2(){
		
		//���������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/test1/applicationContext.xml");
		User user = (User) ac.getBean("user");
		System.out.println(user);
	}
	
	//��������
	@Test
	public void createObject(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/test1/applicationContext.xml");
		User user = (User) ac.getBean("user5");
		System.out.println(user);
	}
	
}
