package com.wk.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;

/*
 * jdbc执行DQL查询语句
 * 
 */
public class JDBC3 {

	
	@Test
	public void test1(){
		
		Connection conn = null;
		Statement state = null;
		ResultSet result = null;
		
		try {
			conn = JdbcUtil.getConnection();
			state = conn.createStatement();
			
			//查询语句
			String sql = "select *from student";
			//执行sql，返回数据保存在ResultSet对象中
			result = state.executeQuery(sql);
			
			while(result.next()){
				//列索引取法
				int id = result.getInt(1);
				String name = result.getString(2);
				int age = result.getInt(3);
				String addr = result.getString(4);
				System.out.println(id+"-"+name+"-"+"-"+age+"-"+addr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, state, result);
		}
		
	}
			
}
