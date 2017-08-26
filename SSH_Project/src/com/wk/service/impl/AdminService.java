package com.wk.service.impl;

import com.wk.dao.IAdminDao;
import com.wk.entity.Admin;
import com.wk.service.IAdminService;

public class AdminService implements IAdminService{

	//IOC注入   
	//实现接口，jdk代理
	private IAdminDao adminDao;
	public void setadminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	
	@Override
	public void register(Admin admin) {
		
		adminDao.save(admin);
	}

	@Override
	public Admin login(Admin admin) {
		
		return adminDao.findById(admin.getId());
	}
	
}
