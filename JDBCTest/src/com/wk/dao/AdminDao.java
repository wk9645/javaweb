package com.wk.dao;

import java.util.List;

import org.junit.Test;

import com.wk.entity.Admin;

public class AdminDao extends BaseDao{
	
	
	//���ݴ����id��ɾ����Ӧ���ݿ��е�ĳ����¼
	public void delete(int id){
		
		String sql = "DELETE FROM admin WHERE id = ?";
		Object[] params = {id};
		super.update(sql, params);
	}
	
	
	//����һ����¼
	public void insert(Admin admin){
		
		String sql = "INSERT INTO admin (username,password) VALUES(?,?)";
		
		Object[] params = {admin.getUserName(),admin.getPassword()};
		
		super.update(sql, params);
	}
	
	
	public List<Admin> findAll(){
		
		String sql = "SELECT * FROM ADMIN";
		List<Admin> admins = super.query(sql, null, Admin.class);
		return admins;
	}
	

	public Admin findById(int id){
		String sql = "SELECT *FROM ADMIN WHERE id=?";
		Object[] paramsValue = {id};
		List<Admin> admins = super.query(sql, paramsValue, Admin.class);
		if(admins.size() > 0 && admins != null){
			return admins.get(0);
		}
		return null;
	}
}
