package com.wk.service;

import com.wk.entity.Admin;

public interface IAdminService {

	/*
	 * ע�᷽��
	 */
	void register(Admin admin);
	
	/*
	 * 
	 * ��¼
	 */
	Admin load(Admin admin);
}
