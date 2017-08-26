package com.wk.service;

import java.util.List;

import com.wk.entity.Employee;

public interface IEmployeeService {

	/*
	 * Ա��service��ӿ�
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
	 *	����ɾ��
	 * @param emp		Ҫɾ����Ա��
	 */
	public void delete(int id);
	
	/**
	 * ɾ�����Ա��
	 * @param ids
	 */
	public void deleteMany(int[] ids);
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
