package com.wk.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import java.sql.PreparedStatement;
import com.wk.jdbc_util.JdbcUtil;


/*
 * ʹ��Ԥ����PrepareStatementִ��sql���
 * 
 */
public class JDBC4 {

	@Test
	public void test(){
		
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			
		conn = JdbcUtil.getConnection();
		String sql = "UPDATE STUDENT SET NAME = ? WHERE id = ?";
		pst = conn.prepareStatement(sql);
		
		//���ò���
		
		pst.setString(1, "����");
		pst.setInt(2, 1);
		
		int count = pst.executeUpdate();
		
		System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pst);
		}
	}
	
}
