package com.wk.connectionPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;


/*
�������ӳ�
-----

���ӳ���Ϊ�˽�������û�ͬʱҪ�����ݿ���в���ʱ������������ѹ����һ�ּ�������Ҫ�Ƕ���һ���洢���ӣ���Connection���󣩵ġ��ء����û�ʹ��ʱ�ӳ���ȡ���������е����ӱ�ȡ������Ҫ�ȴ������ͷŲ���ʹ�á�

��ʹ�ý϶���������ӳؼ�����DBCP���ӳغ�C3P0���ӳ�

���ȿ�һ���Զ�������ӳ����ӣ�����ʹ�õĶ�̬�����*/



/*
 * 
 * ���ӳ�
 */

public class MyPool {

	private int init_count = 3;   //��ʼ������
	private int current_count = 0;  //��ǰ����
	private int max_count = 6;   //������Ӹ���
	
	//��������
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	
	//��ʼ��ʱ����3������
	public MyPool(){
		
		for(int i=0;i<init_count;i++){
			//����һ�����ӣ���ǰ���Ӽ�һ
			current_count++;
			Connection conn = createConnection();
			pool.addLast(conn);
		}
	}
	
	//����������
	public Connection createConnection(){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//�������ӣ�ԭʼ����
			final Connection conn = DriverManager.getConnection("jdbc:mysql:///myfirst", "wk", "199645");
			
			//�����������
			
			Connection proxy = (Connection) Proxy
					.newProxyInstance(conn.getClass().getClassLoader(),
								  new Class[]{Connection.class}, 
								  new InvocationHandler() {
									@Override
									public Object invoke(Object proxy, Method method, Object[] args)
											throws Throwable {
										Object result = null;
										
										//��ȡ����
											String methodName = method.getName();
											
											if("close".equals(methodName)){

												System.out.println("�ѽ������close����");
														
												//ִ���¼ӹ���
												
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
	
	//��ȡ����
	public Connection getConnection(){
		
		//�ж����ӳ��Ƿ������ӣ��������ֱ��ȡ��
		if(pool.size() > 0){
			return pool.removeFirst();
		}
		
		//���û�����ӣ����ж��Ƿ�ﵽ�����������û��ֱ�Ӵ���
		
		else if(current_count < max_count){
			current_count++;
			return createConnection();
		}
		//����Ѵ����ӳ�����������׳��쳣
		throw new RuntimeException("�������Ѵ����");
	}
	
	//�ͷ�����
	public void releaseConnection(Connection conn){
		
		//���ӳ��е��������С�ڳ�ʼ��������ֱ�ӷ������
		if(pool.size() < init_count){
			pool.addLast(conn);
		}
		
		//����ֱ�ӹر�
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
//		System.out.println("��ǰ��������"+p.pool.size());
		
//		Connection conn1 = p.getConnection();
//		Connection conn2 = p.getConnection();
//		Connection conn3 = p.getConnection();
//		
		Connection conn4 = p.getConnection();
		Connection conn5 = p.getConnection();
		Connection conn6 = p.getConnection();
		
//		p.releaseConnection(conn6);
//		Connection conn7 = p.getConnection();
		
		//ִ��close�������������ģʽ
		conn4.close();
		conn5.close();
		p.getConnection();

		
		System.out.println("���ӳ�����"+p.pool.size());
		System.out.println("�����������"+p.max_count);
		System.out.println("��ǰ��������"+p.current_count);
		
		
	}
	
	
}
