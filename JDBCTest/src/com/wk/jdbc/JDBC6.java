package com.wk.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.wk.jdbc_util.JdbcUtil;

/*
 * 
 * 使用CallableStatement对象调用存储过程
 */
public class JDBC6 {

	@Test
	public void test(){
		Connection conn = null;
		CallableStatement cs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			//第一个占位符为输入参数，第二占位符为输出参数	
			String sql = "CALL pro_findById(?,?)";
			cs = conn.prepareCall(sql);
			
			//设置输入参数
			cs.setInt(1, 2);
			//注册输出参数
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			//执行查询
			cs.executeQuery();
			
			//用变量接收输出参数的值,调用getXXX()方法，参数和占位符所在位置对应
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
