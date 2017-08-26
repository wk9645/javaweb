package com.wk.connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


/*
二、连接池
-----

连接池是为了解决大量用户同时要对数据库进行操作时而产生的连接压力的一种技术，主要是定义一个存储连接（即Connection对象）的“池”，用户使用时从池中取出，若池中的连接被取完则需要等待连接释放才能使用。

而使用较多的两种连接池技术有DBCP连接池和C3P0连接池

首先看一个自定义的连接池例子，这里使用的动态代理对*/



/*
 * 
 * 连接池
 */

public class MyPool {

	private int init_count = 3;   //初始化个数
	private int current_count = 0;  //当前个数
	private int max_count = 6;   //最大连接个数
	
	//连接容器
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	
	//初始化时创建3个连接
	public MyPool(){
		
		for(int i=0;i<init_count;i++){
			//创建一个连接，当前连接加一
			current_count++;
			Connection conn = createConnection();
			pool.addLast(conn);
		}
	}
	
	//创建新连接
	public Connection createConnection(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接，原始对象
			final Connection conn = DriverManager.getConnection("jdbc:mysql:///myfirst", "wk", "199645");
			
			//创建代理对象
			
			Connection proxy = (Connection) Proxy
					.newProxyInstance(conn.getClass().getClassLoader(),
								  new Class[]{Connection.class}, 
								  new InvocationHandler() {
									@Override
									public Object invoke(Object proxy, Method method, Object[] args)
											throws Throwable {
										Object result = null;
										
										//获取方法
											String methodName = method.getName();
											
											if("close".equals(methodName)){

												System.out.println("已进入代理close方法");
														
												//执行新加功能
												
												pool.addLast(conn);
											}
											else {
												
												result = method.invoke(conn, args);
											}
											
											
										
										return result;
									}
								}); 
			
			
			return proxy;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	//获取连接
	public Connection getConnection(){
		
		//判断连接池是否有连接，如果有则直接取出
		if(pool.size() > 0){
			return pool.removeFirst();
		}
		
		//如果没有连接，则判断是否达到最大连接数，没有直接创建
		
		else if(current_count < max_count){
			current_count++;
			return createConnection();
		}
		//如果已达连接池最大数，则抛出异常
		throw new RuntimeException("连接数已达最大！");
	}
	
	//释放连接
	public void releaseConnection(Connection conn){
		
		//连接池中的连接如果小于初始化数，则直接放入池中
		if(pool.size() < init_count){
			pool.addLast(conn);
		}
		
		//否则直接关闭
		else {
			try {
				current_count--;
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		MyPool p = new MyPool();
//		System.out.println("当前连接数："+p.pool.size());
		
//		Connection conn1 = p.getConnection();
//		Connection conn2 = p.getConnection();
//		Connection conn3 = p.getConnection();
//		
		Connection conn4 = p.getConnection();
		Connection conn5 = p.getConnection();
		Connection conn6 = p.getConnection();
		
//		p.releaseConnection(conn6);
//		Connection conn7 = p.getConnection();
		
		//执行close方法，进入代理模式
		conn4.close();
		conn5.close();
		p.getConnection();

		
		System.out.println("连接池数："+p.pool.size());
		System.out.println("最大连接数："+p.max_count);
		System.out.println("当前连接数："+p.current_count);
		
		
	}
	
	
}
