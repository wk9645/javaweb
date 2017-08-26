package com.wk.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import com.wk.entity.Employee;

public class EmployeeDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public Employee findById(Serializable id){
		
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
		
	}
}
