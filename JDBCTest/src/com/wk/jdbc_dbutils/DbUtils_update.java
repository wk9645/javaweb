package com.wk.jdbc_dbutils;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;


/*
 * 
 * ʹ��DbUtils����ĸ��·���
 * 
 * ��Ҫ�ࣺQueryRunner����
 * 
 */


public class DbUtils_update {
	
	private Connection conn;
	
	/*
	 * 1������
	 */
	@Test
	public void testUpdate() throws Exception{
		
		String sql = "DELETE FROM ADMIN WHERE id=? ";
		
		conn = JdbcUtil.getConnection();
		
		//��ȡDBUtils���������
		QueryRunner qr = new QueryRunner();
		
		qr.update(conn, sql, 3);
		//�ر�
		DbUtils.close(conn);
	}
	
	
	/*
	 * 2��������
	 */
	
	@Test
	public void testBatch() throws Exception{
		String sql = "insert into admin (userName,password) values(?,?)";
		
		conn = JdbcUtil.getConnection();
		
		QueryRunner qr = new QueryRunner();
		
		qr.batch(conn, sql, new Object[][]{{"����","0000"},{"������","1111"}});
		
		DbUtils.close(conn);
	}
	
}