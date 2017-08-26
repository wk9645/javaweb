package com.wk.service.impl;

import java.util.List;

import com.wk.dao.IDeptDao;
import com.wk.entity.Dept;
import com.wk.service.IDeptService;

public class DeptService implements IDeptService{

	
	
	//×¢ÈëDao
	private IDeptDao deptDao;
	public void setdeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	public List<Dept> getAll() {
		return deptDao.getAll();
	}

	@Override
	public Dept findById(int id) {
		return deptDao.findById(id);
	}

}
