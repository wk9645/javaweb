package com.wk.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	
	//初始化连接池
	
	private static DataSource dataSource;
	
	static{
		dataSource = new ComboPooledDataSource();
	}
	
	//获取连接
	public static QueryRunner getQueryRunner(){
		return new QueryRunner(dataSource);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
