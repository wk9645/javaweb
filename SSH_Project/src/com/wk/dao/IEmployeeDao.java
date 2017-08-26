package com.wk.dao;

import java.util.List;

import sample.EmployeeRecord;

import com.wk.entity.Employee;

public interface IEmployeeDao {
	
	/*
	 * Ա��dao�ӿ�
	 */
	
	/**
	 * 
	 * @param emp	�����Ա��
	 */
	public void save(Employee emp);
	
	
	/**
	 * 
	 * @param id	Ա��id
	 * @return		��Ӧ��Ա��
	 */
	public Employee findById(int id);
	
	/**
	 * 
	 * @param emp		Ҫ�޸ĵ�Ա��
	 */
	public void update(Employee emp);
	
	/**
	 * 
	 * @param emp		Ҫɾ����Ա��
	 */
	public void delete(int id);
	
	/**
	 * 
	 * @return		��������Ա��
	 */
	public List<Employee> getAll();
	
	
	/**
	 * 
	 * @param employeeName	����Ա������
	 * @return		��������Ӧ������Ա��
	 */
	public List<Employee> getAll(String employeeName);
	
}
