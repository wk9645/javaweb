package com.wk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.wk.jdbc_util.JdbcUtil;

public class BaseDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/*
	 	通用Dao，可作为所有自定义Dao的父类
	 	包括更新和查询两个方法
	 */
	
	/**
	 * 更新方法：insert、delete、update
	 * @param sql	要执行更新的sql语句
	 * @param paramsValue	预编译中占位符对应的值	 
	 */
	public void update(String sql, Object[] paramsValue){
		
		try {
			//建立连接并进行预编译
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//获取预编译参数个数
			int count = pstmt.getParameterMetaData().getParameterCount();
			//将值传给参数
			if(paramsValue != null && paramsValue.length > 0){
				for(int i=0; i<count; i++){
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			//执行
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			JdbcUtil.close(conn, pstmt);
		}
		
	}
	
	/**
	 * 通用的查询方法
	 * @param sql	要执行的sql语句
	 * @param paramsValue	参数值
	 * @param clazz	传入的类
	 */
	public <T> List<T> query(String sql, Object[] paramsValue, Class<T> clazz){
		
		//创建一个List
		List<T> list = new ArrayList<T>();
		//创建对象
		T t = null;
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			//获取参数个数
			int count = pstmt.getParameterMetaData().getParameterCount();
			//设置参数值
			if(paramsValue != null && paramsValue.length > 0){
				for(int i=0; i<count; i++){
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			//执行sql
			rs = pstmt.executeQuery();
			ResultSetMetaData rs_meta = rs.getMetaData();
			int columns = rs_meta.getColumnCount();
			//遍历每行每列
			while(rs.next()){
				//每一行创建一个对象
				t = clazz.newInstance();
				
				for(int i=0; i<columns; i++){
					String item = rs_meta.getColumnName(i+1);
					Object value = rs.getObject(item);
					//把数据封装到类属性中
					BeanUtils.copyProperty(t, item, value);
				}
				//将一个对象添加到容器中
				list.add(t);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}	
