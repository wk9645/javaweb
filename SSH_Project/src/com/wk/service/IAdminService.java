package com.wk.service;

import com.wk.entity.Admin;

public interface IAdminService {

	
	/*
	 * 管理員Service接口
	 */
	

	/**
	 * 
	 * @param admin	注册用户
	 */
	void register(Admin admin);
	
	
	/**
	 * 
	 * @param amdin		登录用户
	 * @return		返回已存在用户
	 */
	Admin login(Admin admin);
}
