package com.wk.dao;

import java.util.List;

import sample.EmployeeRecord;

import com.wk.entity.Employee;

public interface IEmployeeDao {
	
	/*
	 * 员工dao接口
	 */
	
	/**
	 * 
	 * @param emp	保存的员工
	 */
	public void save(Employee emp);
	
	
	/**
	 * 
	 * @param id	员工id
	 * @return		对应的员工
	 */
	public Employee findById(int id);
	
	/**
	 * 
	 * @param emp		要修改的员工
	 */
	public void update(Employee emp);
	
	/**
	 * 
	 * @param emp		要删除的员工
	 */
	public void delete(int id);
	
	/**
	 * 
	 * @return		返回所有员工
	 */
	public List<Employee> getAll();
	
	
	/**
	 * 
	 * @param employeeName	输入员工姓名
	 * @return		该姓名对应的所有员工
	 */
	public List<Employee> getAll(String employeeName);
	
}
