package com.wk.service;

import java.util.List;

import com.wk.entity.Dept;

public interface IDeptService {

	
	/*
	 * 部门service接口
	 */
	
	
	/**
	 * 
	 * @return  返回所有的部门信息
	 */
	public List<Dept> getAll();
	
	
	/**
	 * 
	 * @param id   部门id
	 * @return		返回查询到的部门
	 */
	public Dept findById(int id);
}
