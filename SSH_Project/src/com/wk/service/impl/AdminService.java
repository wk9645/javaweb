package com.wk.service.impl;

import com.wk.dao.IAdminDao;
import com.wk.entity.Admin;
import com.wk.service.IAdminService;

public class AdminService implements IAdminService{

	//IOCע��   
	//ʵ�ֽӿڣ�jdk����
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
