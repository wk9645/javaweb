package com.wk.dao;

import java.util.List;

import com.wk.entity.Dept;


public interface IDeptDao {

	/*
	 * ����dao�ӿ�
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
