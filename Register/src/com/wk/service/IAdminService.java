package com.wk.service;

import com.wk.entity.Admin;
import com.wk.exception.AdminExistsException;

public interface IAdminService {

	/*
	 * ҵ���߼���ӿ����
	 */
	
	/**
	 * ע��
	 * @param admin
	 */
	void register(Admin admin) throws AdminExistsException;
	
	
	/**
	 * ��¼
	 * @param admin
	 * @return ���ص�¼���û�
	 */
	Admin login(Admin admin);
}
