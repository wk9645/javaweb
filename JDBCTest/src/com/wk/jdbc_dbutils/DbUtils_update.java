package com.wk.jdbc_dbutils;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;


/*
 * 
 * 使用DbUtils组件的更新方法
 * 
 * 主要类：QueryRunner对象
 * 
 */


public class DbUtils_update {
	
	private Connection conn;
	
	/*
	 * 1、更新
	 */
	@Test
	public void testUpdate() throws Exception{
		
		String sql = "DELETE FROM ADMIN WHERE id=? ";
		
		conn = JdbcUtil.getConnection();
		
		//获取DBUtils组件核心类
		QueryRunner qr = new QueryRunner();
		
		qr.update(conn, sql, 3);
		//关闭
		DbUtils.close(conn);
	}
	
	
	/*
	 * 2、批处理
	 */
	
	@Test
	public void testBatch() throws Exception{
		String sql = "insert into admin (userName,password) values(?,?)";
		
		conn = JdbcUtil.getConnection();
		
		QueryRunner qr = new QueryRunner();
		
		qr.batch(conn, sql, new Object[][]{{"刀妹","0000"},{"德莱文","1111"}});
		
		DbUtils.close(conn);
	}
	
}
