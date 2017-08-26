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
	 * ʹ��spring��������
	 */
	public void save(Dept dept) {
		
		sessionFactory.getCurrentSession().save(dept);
	}
	
	/*
	 * hibernate��������
	 */
	/*public void save(Dept dept) {

		//����session
		Session session = sessionFactory.openSession();
		//��������
		session.beginTransaction();
		//����
		session.save(dept);
		
		//�ύ����
		session.getTransaction().commit();
		session.close();
	}
	*/
	
}
