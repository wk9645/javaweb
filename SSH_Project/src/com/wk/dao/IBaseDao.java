package com.wk.dao;

import java.util.List;

public interface IBaseDao<T> {

	/*
	 * dao接口
	 */
	
	/**
	 * 
	 * @param t	
	 */
	public void save(T t);
	
	
	/**
	 * 
	 * @param id	员工id
	 * @return		
	 */
	public T findById(int id);
	
	/**
	 * 
	 * @param t		
	 */
	public void update(T t);
	
	/**
	 * 
	 * @param id		
	 */
	public void delete(int id);
	
	/**
	 * 
	 * @return		
	 */
	public List<T> getAll();
	
}
