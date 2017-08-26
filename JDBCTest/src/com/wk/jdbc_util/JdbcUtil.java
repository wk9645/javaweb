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
 * JDBC���ӹ�����
 * 
 */
public class JdbcUtil {
	
	private static String user = null;
	private static String password = null;
	
	//�������ݿ��url
	private static String url = null;
	private static String driverClass = null;
	
	//��̬��������ע����������
	static{
		try {
			
			//ʹ��Propertise����
			Properties p = new Properties();
//			FileInputStream in = new FileInputStream("./src/db.properties");
			
			/*
			 * ʹ����·���Ķ�ȡ��ʽ
			 * 
			 *  /  ��ʾclasspath�ĸ�Ŀ¼
			 *  
			 *  java��Ŀ�У�classpath�ĸ�Ŀ¼��bin��ʼ
			 *  ��web��Ŀ�У�classpath�ĸ�Ŀ¼��WEB-INF/classesĿ¼��ʼ
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
	 * @param conn  Connection����
	 * @param state	Statement����
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
	 * @param conn    Connection����
 	 * @param state	  Statement����
	 * @param rSet	  ResultSet����
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
