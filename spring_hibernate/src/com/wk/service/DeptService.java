package com.wk.service;

import com.wk.dao.DeptDao;
import com.wk.entity.Dept;

public class DeptService {

	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public void save(Dept dept){
		
		deptDao.save(dept);
//		int i = 1/0;
		
	}
	
	
}
