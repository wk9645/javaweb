package com.wk.dao;

import com.wk.entity.Admin;

/*
 * ʵ���ӿڷ���
 * 
 */


public interface IAdminDao {

	/**
	 * ע�ᱣ��
	 * @param admin
	 */
	void save(Admin admin);
	
	/**
	 * �����û��������ѯ
	 * @param admin ���ҵ��û�
	 * @return	�������ݿ��ҵ����û�
	 */
	Admin findByNameAndPwd(Admin admin);
	
	/**
	 * �û����Ƿ����
	 * @param name ���������
	 * @return true��ʾ����
	 */
	boolean adminExist(String name);
	
	
}
