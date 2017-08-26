package com.wk.connectionPool;

import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/*
 * C3P0���ӳ�
 * 
 */

public class C3p0Test {
	
	
	
	//���������ò���
	@Test
	public void test1() throws Exception{
		
		//����������
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		
		
		/*
		 * ��������
		 */
		cpds.setJdbcUrl("jdbc:mysql:///myfirst");   
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setUser("wk");
		cpds.setPassword("199645");
		
		cpds.setInitialPoolSize(3);  //��ʼ��������
		cpds.setMaxPoolSize(6); //���������
		cpds.setMaxIdleTime(3000);  //������ʱ��
		
		
		Connection conn = cpds.getConnection();
		
		conn.prepareStatement("insert into admin (userName,password) values ('С��',123456)").executeUpdate();
		
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
