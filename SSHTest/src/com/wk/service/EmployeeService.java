package com.wk.service;

import java.io.Serializable;

import com.wk.dao.EmployeeDao;
import com.wk.entity.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public Employee findById(Serializable id){
		
		return employeeDao.findById(id);
	}
}
