package com.wk.connectionPool;

import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/*
 * C3P0连接池
 * 
 */

public class C3p0Test {
	
	
	
	//代码中配置参数
	@Test
	public void test1() throws Exception{
		
		//创建核心类
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		
		
		/*
		 * 参数配置
		 */
		cpds.setJdbcUrl("jdbc:mysql:///myfirst");   
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setUser("wk");
		cpds.setPassword("199645");
		
		cpds.setInitialPoolSize(3);  //初始化连接数
		cpds.setMaxPoolSize(6); //最大连接数
		cpds.setMaxIdleTime(3000);  //最大空闲时间
		
		
		Connection conn = cpds.getConnection();
		
		conn.prepareStatement("insert into admin (userName,password) values ('小红',123456)").executeUpdate();
		
		conn.close();
	}
	
	@Test
	public void test2() throws Exception{
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		
		Connection conn = cpds.getConnection();
		conn.prepareStatement("delete from admin where id=5").executeUpdate();
		
		conn.close();
	
	}
	
}
