package com.wk.dao;

import com.wk.entity.Admin;


/**
 * 2. ���ݷ��ʲ�, �ӿ����
 * @author Jie.Yuan
 *
 */
public interface IAdminDao {

	/**
	 * ����
	 * @param admin
	 */
	void save(Admin admin);
	
	/**
	 * �����û��������ѯ
	 */
	Admin findByNameAndPwd(Admin admin);
	
	/**
	 * ����û����Ƿ����
	 * @param name   Ҫ�����û���
	 * @return  true��ʾ�û����Ѿ����ڣ� �����û���������
	 */
	boolean userExists(String name);
}












