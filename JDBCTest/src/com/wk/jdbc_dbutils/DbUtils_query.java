package com.wk.jdbc_dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.wk.entity.Admin;
import com.wk.jdbc_util.JdbcUtil;

public class DbUtils_query {
	
	private Connection conn;
	
	/*
	 * ��ѯ����
	 * 
	 */
	
	
	
	//1���Զ���������װ����
	
	@Test
	public void testQuery() throws Exception{
		
		String sql = "select *from admin where id=? ";
		
		conn = JdbcUtil.getConnection();
		
		QueryRunner qr = new QueryRunner();
		
		Admin admin = qr.query(conn, sql, new ResultSetHandler<Admin>() {

			@Override
			public Admin handle(ResultSet rs) throws SQLException {
				//ÿһ�з�װΪһ������
				if(rs.next()){
					Admin admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setUserName(rs.getString("userName"));
					admin.setPassword(rs.getString("password"));
					return admin;
				}
				return null;
			}

		},5);
		
		DbUtils.close(conn);
		
		System.out.println(admin);
	}
	
	
	
	//2��ʹ��DbUtils��ȡ���������װ����,��ȡ��������BeanHandler
	@Test
	public void testDbUtilsQueryOne() throws Exception{
		
		String sql = "select *from admin where id=? ";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
	
		Admin admin = qr.query(conn, sql, new BeanHandler<Admin>(Admin.class), 6);
		
		DbUtils.close(conn);
		System.out.println(admin);
	}
	
	//3����ȡ���󼯺ϣ�BeanListHandler
	@Test
	public void testDbUtilsQueryMore() throws Exception{
		String sql = "select *from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		
		List<Admin> admins = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		
		DbUtils.close(conn);
		System.out.println(admins);
		
	}
	
	//��ȡ�������������ʽ
	@Test
	public void testDbUtilsQueryOther() throws Exception{
		
		String sql = "select * from admin";
		conn = JdbcUtil.getConnection();
		QueryRunner qr = new QueryRunner();
		
		Object[] objs = qr.query(conn, sql, new ArrayHandler());
		List<Object[]> lists = qr.query(conn, sql, new ArrayListHandler());
		Long num = qr.query(conn, sql, new ScalarHandler<Long>());
		Map<String, Object> maps = qr.query(conn, sql, new MapHandler());
		
		DbUtils.close(conn);
	
	}
	
}
