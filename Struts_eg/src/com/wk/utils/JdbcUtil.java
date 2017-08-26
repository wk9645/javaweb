package com.wk.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	
	//��ʼ�����ӳ�
	
	private static DataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	//��ȡ����
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
