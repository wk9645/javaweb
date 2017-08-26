package com.wk.jdbc_util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 
 * JDBC连接工具类
 * 
 */
public class JdbcUtil {
	
	private static String user = null;
	private static String password = null;
	
	//连接数据库的url
	private static String url = null;
	private static String driverClass = null;
	
	//静态代码块加载注册驱动程序
	static{
		try {
			
			//使用Propertise对象
			Properties p = new Properties();
//			FileInputStream in = new FileInputStream("./src/db.properties");
			
			/*
			 * 使用类路径的读取方式
			 * 
			 *  /  表示classpath的根目录
			 *  
			 *  java项目中，classpath的根目录从bin开始
			 *  在web项目中，classpath的根目录从WEB-INF/classes目录开始
			 * 
			 */
			InputStream in = JdbcUtil.class.getResourceAsStream("/db.properties");
			p.load(in);
			
			user = p.getProperty("user");
			password = p.getProperty("password");
			url = p.getProperty("url");
			driverClass = p.getProperty("driverClass");
			
			/*System.out.println(user);
			System.out.println(password);
			System.out.println(url);
			System.out.println(driverClass);*/
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	/**
	 * 
	 * @param conn  Connection对象
	 * @param state	Statement对象
	 */
	public static void close(Connection conn,Statement state){
		
		if(state!=null)
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
		}
	}
	
	/**
	 * 
	 * @param conn    Connection对象
 	 * @param state	  Statement对象
	 * @param rSet	  ResultSet对象
	 */
	public static void close(Connection conn,Statement state,ResultSet rSet){
		if(rSet!=null)
			try {
				rSet.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		if(state!=null)
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
	}
	
}
