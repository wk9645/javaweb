package com.wk.shiwu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;


/*
 * 
 * 转账描述事务
 * 
 * 
 */
public class Trans {
	
	Connection conn;
	PreparedStatement pstmt;
	
	//不适用事务
	@Test
	public void trans1(){
		
		String sql_zs = "UPDATE account SET  money=money-1000 WHERE NAME='张三'";
		String sql_ls = "UPDATE account SET  money=money+1000 WHERE NAME='李四'"; 
		
		try {
			conn = JdbcUtil.getConnection();
			//执行第一次sql
			pstmt = conn.prepareStatement(sql_zs);
			pstmt.execute();
			
			//执行第二次sql
			pstmt = conn.prepareStatement(sql_ls);
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	
	//使用事务，不设置保存点
	@Test
	public void trans2(){
		
		String sql_zs = "UPDATE account SET  money=money-1000 WHERE NAME='张三'";
		String sql_ls = "UPDATE account SET  money=money+1000 WHERE NAME='李四'"; 
		
		try {
			conn = JdbcUtil.getConnection();
			//设置为手动保存
			conn.setAutoCommit(false);
			//执行第一次sql
			pstmt = conn.prepareStatement(sql_zs);
			pstmt.execute();
			
			//执行第二次sql
			pstmt = conn.prepareStatement(sql_ls);
			pstmt.execute();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			
			try {
				conn.commit();
				JdbcUtil.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//使用事务，设置保存点
	@Test
	public void trans3(){
		
		Savepoint sp = null;
		
		
		String sql_zs1 = "UPDATE account SET  money=money-1000 WHERE NAME='张三'";
		String sql_ls1 = "UPDATE account SET  money=money+1000 WHERE NAME='李四'"; 
		
		String sql_zs2 = "UPDATE account SET  money=money-500 WHERE NAME='张三'";
		String sql_ls2 = "UPDATE account SET  money=money+500 WHERE NAME='李四'"; 
		
		try {
			conn = JdbcUtil.getConnection();
			//设置为手动提交
			conn.setAutoCommit(false);
			
			//执行第一次sql
			pstmt = conn.prepareStatement(sql_zs1);
			pstmt.execute();
			
			pstmt = conn.prepareStatement(sql_ls1);
			pstmt.execute();
			
			//设置保存点
			sp = conn.setSavepoint();
			
			//执行第二次sql
			pstmt = conn.prepareStatement(sql_zs2);
			pstmt.execute();
			
			pstmt = conn.prepareStatement(sql_ls2);
			pstmt.execute();
			
		} catch (Exception e) {
			try {
				//回滚到保存点处
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.commit();
				JdbcUtil.close(conn, pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
