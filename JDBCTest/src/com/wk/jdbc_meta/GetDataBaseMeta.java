package com.wk.jdbc_meta;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import java.sql.PreparedStatement;
import com.wk.jdbc_util.JdbcUtil;

public class GetDataBaseMeta {

	
	/*
	 * 
	 * 获取sql语句参数个数，ParameterMetaData对象
	 */
	
	@Test
	public void test1(){
		
	
		Connection conn = null;
		PreparedStatement pstat = null;
		
		try {
			conn = JdbcUtil.getConnection();
			
			String sql = "select * from student where id=? and name=?";
			pstat = conn.prepareStatement(sql);
			ParameterMetaData pmd = pstat.getParameterMetaData();
			
			System.out.println(pmd.getParameterCount());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat);
		}
		
	}
	
	/*
	 * 获取结果集元数据，ResultSetMetaData对象
	 * 
	 */
	@Test
	public void test2(){
		
		Connection conn = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			
			String sql = "SELECT *FROM student";
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			//获取结果集元数据
			ResultSetMetaData rs_meta = rs.getMetaData();
			//获取列个数
			int count = rs_meta.getColumnCount();
			
			while(rs.next()){
				for(int i=1;i<=count;++i){
					
					String item = rs_meta.getColumnName(i);  //每一列的名称
					Object value = rs.getObject(i);    //获取一行值
					System.out.print(item+":"+value+"\t");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, pstat, rs);
		}
		
	}
	
	
}
