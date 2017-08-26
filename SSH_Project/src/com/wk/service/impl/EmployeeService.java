package com.wk.service.impl;

import java.util.List;

import com.wk.dao.IEmployeeDao;
import com.wk.entity.Employee;
import com.wk.service.IEmployeeService;

public class EmployeeService implements IEmployeeService{

	
	
	//×¢ÈëÈÝÆ÷
	private IEmployeeDao employeeDao;
	public void setemployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void save(Employee emp) {
		
		employeeDao.save(emp);
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void update(Employee emp) {

		employeeDao.update(emp);
	}

	@Override
	public void delete(int id) {

		employeeDao.delete(id);
	}

	@Override
	public void deleteMany(int[] ids) {
		
		if(ids !=null && ids.length > 0){
			
			int num = ids.length;
			for(int i=0; i<ids.length; i++){
				delete(ids[i]);
			}
		}
		
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeDao.getAll();
	}

	@Override
	public List<Employee> getAll(String employeeName) {
		
		return employeeDao.getAll(employeeName);
	}

}
