package com.wk.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wk.entity.Admin;
import com.wk.utils.JdbcUtil;

public class AdminDao {

	/*
	 * 1、获取单个记录
	 */
	public Admin getAdmin(Admin admin){
		
		try {
			String sql = "select *from admin where userName=? and password=?";
			
			return JdbcUtil.getQueryRunner().query(sql,new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPwd());
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 获取列表
	 */
	
	public List<Admin> getAll(){
		
		try {
			String sql = "select *from admin";
			
			return JdbcUtil.getQueryRunner().query(sql, new BeanListHandler<Admin>(Admin.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
