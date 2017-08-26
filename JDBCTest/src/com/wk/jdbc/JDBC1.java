package com.wk.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

/*
 * 
 * ��������mysql���ݿ�ķ���
 */

public class JDBC1 {
	
	private String user = "wk";
	private String psw = "199645";
	
	//�������ݿ��url
	private String url = "jdbc:mysql://localhost:3306/test";
	
	@Test
	public void test() throws Exception{
		
		//1��������������
		Driver driver = new com.mysql.jdbc.Driver();
		
		//2�������û���������
		
		Properties property = new Properties();
		property.setProperty("user", user);
		property.setProperty("psw", psw);
		
		//3���������ݿ�
		
		Connection conn = driver.connect(url, property);
		System.out.println("test1����");
		System.out.println(conn);
	}
	
	@Test
	public void test2() throws Exception{
		Driver driver = new com.mysql.jdbc.Driver();
		
		//ʹ��DriverManager��������
		//1��ע��
		DriverManager.registerDriver(driver);
		
		//2������
		Connection conn = DriverManager.getConnection(url,user,psw);
		System.out.println("test2����");
		System.out.println(conn);
		
	}
	
	@Test
	public void test3() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url,user,psw);
		System.out.println("test3����");
		System.out.println(conn);
	}
}
