package com.wk.dao;

import com.wk.entity.Admin;

/*
 * 实体层接口方法
 * 
 */


public interface IAdminDao {

	/**
	 * 注册保存
	 * @param admin
	 */
	void save(Admin admin);
	
	/**
	 * 根据用户名密码查询
	 * @param admin 查找的用户
	 * @return	返回数据库找到的用户
	 */
	Admin findByNameAndPwd(Admin admin);
	
	/**
	 * 用户名是否存在
	 * @param name 输入的名字
	 * @return true表示存在
	 */
	boolean adminExist(String name);
	
	
}
