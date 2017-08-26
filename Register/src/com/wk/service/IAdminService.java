package com.wk.service;

import com.wk.entity.Admin;
import com.wk.exception.AdminExistsException;

public interface IAdminService {

	/*
	 * 业务逻辑层接口设计
	 */
	
	/**
	 * 注册
	 * @param admin
	 */
	void register(Admin admin) throws AdminExistsException;
	
	
	/**
	 * 登录
	 * @param admin
	 * @return 返回登录的用户
	 */
	Admin login(Admin admin);
}
