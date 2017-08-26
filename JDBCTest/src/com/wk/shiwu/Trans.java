package com.wk.shiwu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;


/*
 * 
 * ת����������
 * 
 * 
 */
public class Trans {
	
	Connection conn;
	PreparedStatement pstmt;
	
	//����������
	@Test
	public void trans1(){
		
		String sql_zs = "UPDATE account SET  money=money-1000 WHERE NAME='����'";
		String sql_ls = "UPDATE account SET  money=money+1000 WHERE NAME='����'"; 
		
		try {
			conn = JdbcUtil.getConnection();
			//ִ�е�һ��sql
			pstmt = conn.prepareStatement(sql_zs);
			pstmt.execute();
			
			//ִ�еڶ���sql
			pstmt = conn.prepareStatement(sql_ls);
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	
	//ʹ�����񣬲����ñ����
	@Test
	public void trans2(){
		
		String sql_zs = "UPDATE account SET  money=money-1000 WHERE NAME='����'";
		String sql_ls = "UPDATE account SET  money=money+1000 WHERE NAME='����'"; 
		
		try {
			conn = JdbcUtil.getConnection();
			//����Ϊ�ֶ�����
			conn.setAutoCommit(false);
			//ִ�е�һ��sql
			pstmt = conn.prepareStatement(sql_zs);
			pstmt.execute();
			
			//ִ�еڶ���sql
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
	
	
	//ʹ���������ñ����
	@Test
	public void trans3(){
		
		Savepoint sp = null;
		
		
		String sql_zs1 = "UPDATE account SET  money=money-1000 WHERE NAME='����'";
		String sql_ls1 = "UPDATE account SET  money=money+1000 WHERE NAME='����'"; 
		
		String sql_zs2 = "UPDATE account SET  money=money-500 WHERE NAME='����'";
		String sql_ls2 = "UPDATE account SET  money=money+500 WHERE NAME='����'"; 
		
		try {
			conn = JdbcUtil.getConnection();
			//����Ϊ�ֶ��ύ
			conn.setAutoCommit(false);
			
			//ִ�е�һ��sql
			pstmt = conn.prepareStatement(sql_zs1);
			pstmt.execute();
			
			pstmt = conn.prepareStatement(sql_ls1);
			pstmt.execute();
			
			//���ñ����
			sp = conn.setSavepoint();
			
			//ִ�еڶ���sql
			pstmt = conn.prepareStatement(sql_zs2);
			pstmt.execute();
			
			pstmt = conn.prepareStatement(sql_ls2);
			pstmt.execute();
			
		} catch (Exception e) {
			try {
				//�ع�������㴦
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
