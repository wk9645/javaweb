package com.wk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1. �������� 
 * 2. �ر�
 * 
 * @author wk
 * 
 */
public class JdbcUtil {

	// ���Ӳ���
	// private String url = "jdbc:mysql://localhost:3306/myfirst";
	private static String url = "jdbc:mysql:///myfirst";
	private static String user = "wk";
	private static String password = "199645";

	/**
	 * �������Ӷ���
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * �ر�
	 */
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();   
				rs = null;   // ������Դ
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null && !con.isClosed()) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}










