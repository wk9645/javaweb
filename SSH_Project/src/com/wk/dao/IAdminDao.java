package com.wk.dao;

import com.wk.entity.Admin;

public interface IAdminDao {

	/*
	 * ����Ա�ӿ�ʵ��
	 */
	
	
	/**
	 * 
	 * @param admin  ����Ĺ���Ա
	 */
	public void save(Admin admin);
	
	
	/**
	 * 
	 * @param id  Ҫ��ѯ�Ĺ���Ա
	 * @return	���ز�ѯ���Ĺ���Ա
	 */
	public Admin findById(int id);
	
}
