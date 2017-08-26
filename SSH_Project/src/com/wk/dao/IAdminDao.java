package com.wk.dao;

import com.wk.entity.Admin;

public interface IAdminDao {

	/*
	 * 管理员接口实现
	 */
	
	
	/**
	 * 
	 * @param admin  保存的管理员
	 */
	public void save(Admin admin);
	
	
	/**
	 * 
	 * @param id  要查询的管理员
	 * @return	返回查询到的管理员
	 */
	public Admin findById(int id);
	
}
