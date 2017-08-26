package com.wk.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import com.wk.dao.IBaseDao;

public class BaseDao<T> implements IBaseDao<T> {

	
	private Class<T> clazz;
	private String className;
	
	//ע��sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public BaseDao(){
	
		//��ȡ��������
		Type type = this.getClass().getGenericSuperclass();
		
		//��ȡ����Ĳ���������
		ParameterizedType pType = (ParameterizedType) type;
		
		//��ȡ����ʵ�ʲ�������
		Type[] types = pType.getActualTypeArguments();
		
		//��ȡ����
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
