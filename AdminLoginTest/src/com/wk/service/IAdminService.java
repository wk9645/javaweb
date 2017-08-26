package com.wk.service;

import com.wk.entity.Admin;

public interface IAdminService {

	/*
	 * ×¢²á·½·¨
	 */
	void register(Admin admin);
	
	/*
	 * 
	 * µÇÂ¼
	 */
	Admin load(Admin admin);
}
