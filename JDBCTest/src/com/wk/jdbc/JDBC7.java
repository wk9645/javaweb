package com.wk.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;


/*
 * 
 * ��ȡ����������������
 */
public class JDBC7 {
	
	
	@Test
	public void test(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			
			String sql = "INSERT INTO student (NAME,age,address) VALUES (?,?,?)";
			
			//���û�ȡ��������
			pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,"����");
			pstmt.setInt(2, 65);
			pstmt.setString(3, "���");
			
			//ִ��sql���
			pstmt.execute();
			
			//��ȡ�������еĽ����
			rs = pstmt.getGeneratedKeys();
			
			if(rs.next()){
				System.out.println(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
}
