package com.wk.dao.impl;

import java.util.List;

import com.wk.dao.IEmployeeDao;
import com.wk.entity.Employee;

public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String employeeName) {
		
		return getSessionFactory().getCurrentSession()
				.createQuery("from Employee where empName like ?")
				.setParameter(0, "%" +employeeName+ "%")
				.list();
	}
	
}
