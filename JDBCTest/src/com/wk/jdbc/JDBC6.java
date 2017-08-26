package com.wk.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;

/*
 * 
 * ʹ��CallableStatement������ô洢����
 */
public class JDBC6 {

	@Test
	public void test(){
		Connection conn = null;
		CallableStatement cs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			//��һ��ռλ��Ϊ����������ڶ�ռλ��Ϊ�������	
			String sql = "CALL pro_findById(?,?)";
			cs = conn.prepareCall(sql);
			
			//�����������
			cs.setInt(1, 2);
			//ע���������
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			//ִ�в�ѯ
			cs.executeQuery();
			
			//�ñ����������������ֵ,����getXXX()������������ռλ������λ�ö�Ӧ
			String result = cs.getString(2);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, cs);
		}
		
		
	}
}
