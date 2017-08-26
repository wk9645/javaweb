package com.wk.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;

/*
 * 
 * Statement的注入问题
 */
public class JDBC5 {

	private String name = "小明' OR 1=1 -- ";
	private String passward = "3456";
	
	@Test
	public void test(){
		
		Connection conn = null;
		Statement stat = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = JdbcUtil.getConnection();
			stat = conn.createStatement();
			
			String sql = "SELECT *FROM admin WHERE userName='"+name+"' AND password='"+passward+"'";
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("successed");
			}else{
				System.out.println("failed");
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JdbcUtil.close(conn, stat);
		}
	}
	
}
