package com.wk.connectionPool;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;



/*
 * DBCP����,BasicDataSource
 */

public class DBCPTest {
	
	
	
	@Test
	public void test() throws Exception{
		
		//DBCP���Ӻ�����
		BasicDataSource bds = new BasicDataSource();
		/*
		 * ��������
		 */
		bds.setUrl("jdbc:mysql:///myfirst");   
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUsername("wk");
		bds.setPassword("199645");
		
		bds.setInitialSize(3);  //��ʼ��������
		bds.setMaxActive(6); //���������
		bds.setMaxIdle(3000);  //������ʱ��
		
		
		Connection conn = bds.getConnection();
		conn.prepareStatement("insert into admin (userName,password) values ('С��',123456)").executeUpdate();
		
		conn.close();
	}
	
	
	
	//ʹ�������ļ�

	@Test
	public void testProperty() throws Exception{
		
		Properties prop = new Properties();
		
		InputStream is = DBCPTest.class.getResourceAsStream("db_dbcp.properties");
		prop.load(is);
		DataSource ds = BasicDataSourceFactory.createDataSource(prop);
		
		Connection conn = ds.getConnection();
		
		conn.prepareStatement("insert into admin (userName,password) values ('����',4789)").executeUpdate();
		
		conn.close();
	}
	
}
