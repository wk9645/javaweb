package com.wk.service;

import java.util.List;

import com.wk.dao.AdminDao;
import com.wk.entity.Admin;

public class AdminService {

	
	AdminDao aDao = new AdminDao();
	public Admin getAdmin(Admin admin){
		
		try {
			
			return aDao.getAdmin(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Admin> getAll(){
		try {
			return aDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
