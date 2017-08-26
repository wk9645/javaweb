package com.wk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/*
 * 使用jdbc执行sql语句
 * 
 */
public class JDBC2 {


	private String user = "wk";
	private String psw = "199645";
	
	//连接数据库的url
	private String url = "jdbc:mysql://localhost:3306/myfirst";
	
	@Test
	public void test1(){
		
		Statement state = null; //com.sql.Statement
		Connection conn = null;
		
		//加载驱动
		//发送sql语句
		String sql = "create table teacher("+
				"id int primary key auto_increment,"+
				"name varchar(10),"+ 
				"class varchar(20));";
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,psw);
			state = conn.createStatement();
			
			//更新行数
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
