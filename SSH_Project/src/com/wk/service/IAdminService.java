package com.wk.service;

import com.wk.entity.Admin;

public interface IAdminService {

	
	/*
	 * ����TService�ӿ�
	 */
	

	/**
	 * 
	 * @param admin	ע���û�
	 */
	void register(Admin admin);
	
	
	/**
	 * 
	 * @param amdin		��¼�û�
	 * @return		�����Ѵ����û�
	 */
	Admin login(Admin admin);
}
