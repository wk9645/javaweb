package com.wk.dao;

import org.hibernate.SessionFactory;

import com.wk.entity.Dept;


public class DeptDao {

//	private static SessionFactory sessionFactory;
//	
//	static{
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//	}
	
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	/*
	 * 使用spring管理事务
	 */
	public void save(Dept dept) {
		
		sessionFactory.getCurrentSession().save(dept);
	}
	
	/*
	 * hibernate创建事务
	 */
	/*public void save(Dept dept) {

		//开启session
		Session session = sessionFactory.openSession();
		//开启事务
		session.beginTransaction();
		//保存
		session.save(dept);
		
		//提交事务
		session.getTransaction().commit();
		session.close();
	}
	*/
	
}
