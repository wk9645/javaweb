package com.wk.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import com.wk.dao.IBaseDao;

public class BaseDao<T> implements IBaseDao<T> {

	
	private Class<T> clazz;
	private String className;
	
	//注入sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public BaseDao(){
	
		//获取父类类型
		Type type = this.getClass().getGenericSuperclass();
		
		//获取父类的参数化类型
		ParameterizedType pType = (ParameterizedType) type;
		
		//获取所有实际参数类型
		Type[] types = pType.getActualTypeArguments();
		
		//获取参数
		clazz = (Class<T>) types[0];

		className = clazz.getSimpleName();
	}
	
	
	@Override
	public void save(T t) {
		
		sessionFactory.getCurrentSession().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		
		
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(int id) {
		
		sessionFactory.getCurrentSession()
			.createQuery("delete from " + className + " where id=?") 
			.setParameter(0, id)
			.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from " + className).list();
	}

}
