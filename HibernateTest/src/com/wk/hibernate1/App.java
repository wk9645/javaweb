package com.wk.hibernate1;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	
	
	@Test
	public void testHello(){
		
		/*
		 * 1、实例化对象
		 */
		Employee emp = new Employee();
		emp.setEmpName("王五");
		emp.setWorkDate(new Date());
		
		
		/*
		 * 2、获取加载配置文件的管理类对象
		 */
		Configuration config = new Configuration();
		config.configure();   //加载数据库配置文件
		
		
		/*
		 * 3、创建session的工厂类
		 */
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();                 //创建session
		
		Transaction ts = session.beginTransaction();		//开启事务
		
		//保存对象到数据库
		session.save(emp);
		
		//提交事务
		ts.commit();
		//关闭
		sf.close();
		session.close();
		
	}
	
}
