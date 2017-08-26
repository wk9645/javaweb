package com.wk.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

/*
 * 
 * 测试连接mysql数据库的方法
 */

public class JDBC1 {
	
	private String user = "wk";
	private String psw = "199645";
	
	//连接数据库的url
	private String url = "jdbc:mysql://localhost:3306/test";
	
	@Test
	public void test() throws Exception{
		
		//1、创建驱动程序
		Driver driver = new com.mysql.jdbc.Driver();
		
		//2、设置用户名和密码
		
		Properties property = new Properties();
		property.setProperty("user", user);
		property.setProperty("psw", psw);
		
		//3、连接数据库
		
		Connection conn = driver.connect(url, property);
		System.out.println("test1连接");
		System.out.println(conn);
	}
	
	@Test
	public void test2() throws Exception{
		Driver driver = new com.mysql.jdbc.Driver();
		
		//使用DriverManager管理驱动
		//1、注册
		DriverManager.registerDriver(driver);
		
		//2、连接
		Connection conn = DriverManager.getConnection(url,user,psw);
		System.out.println("test2连接");
		System.out.println(conn);
		
	}
	
	@Test
	public void test3() throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url,user,psw);
		System.out.println("test3连接");
		System.out.println(conn);
	}
}
