package com.wk.connectionPool;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;



/*
 * DBCP连接,BasicDataSource
 */

public class DBCPTest {
	
	
	
	@Test
	public void test() throws Exception{
		
		//DBCP连接核心类
		BasicDataSource bds = new BasicDataSource();
		/*
		 * 参数配置
		 */
		bds.setUrl("jdbc:mysql:///myfirst");   
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUsername("wk");
		bds.setPassword("199645");
		
		bds.setInitialSize(3);  //初始化连接数
		bds.setMaxActive(6); //最大连接数
		bds.setMaxIdle(3000);  //最大空闲时间
		
		
		Connection conn = bds.getConnection();
		conn.prepareStatement("insert into admin (userName,password) values ('小明',123456)").executeUpdate();
		
		conn.close();
	}
	
	
	
	//使用配置文件

	@Test
	public void testProperty() throws Exception{
		
		Properties prop = new Properties();
		
		InputStream is = DBCPTest.class.getResourceAsStream("db_dbcp.properties");
		prop.load(is);
		DataSource ds = BasicDataSourceFactory.createDataSource(prop);
		
		Connection conn = ds.getConnection();
		
		conn.prepareStatement("insert into admin (userName,password) values ('张三',4789)").executeUpdate();
		
		conn.close();
	}
	
}
