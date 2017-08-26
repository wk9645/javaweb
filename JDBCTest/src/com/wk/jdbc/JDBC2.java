package com.wk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/*
 * ʹ��jdbcִ��sql���
 * 
 */
public class JDBC2 {


	private String user = "wk";
	private String psw = "199645";
	
	//�������ݿ��url
	private String url = "jdbc:mysql://localhost:3306/myfirst";
	
	@Test
	public void test1(){
		
		Statement state = null; //com.sql.Statement
		Connection conn = null;
		
		//��������
		//����sql���
		String sql = "create table teacher("+
				"id int primary key auto_increment,"+
				"name varchar(10),"+ 
				"class varchar(20));";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,psw);
			state = conn.createStatement();
			
			//��������
			int count = state.executeUpdate(sql);
			System.out.println(count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(state != null)
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}
