package com.wk.service;

import java.util.List;

import com.wk.entity.Dept;

public interface IDeptService {

	
	/*
	 * ����service�ӿ�
	 */
	
	
	/**
	 * 
	 * @return  �������еĲ�����Ϣ
	 */
	public List<Dept> getAll();
	
	
	/**
	 * 
	 * @param id   ����id
	 * @return		���ز�ѯ���Ĳ���
	 */
	public Dept findById(int id);
}
