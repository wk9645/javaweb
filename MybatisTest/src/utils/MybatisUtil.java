package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 * mybatis��ȡ���ӹ�����
 * 
 */


public class MybatisUtil {

	
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sessionFactory;
	
	
	static{
		
		Reader reader;
		try {
			//���������ļ�
			reader = Resources.getResourceAsReader("mybatis.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	private MybatisUtil(){}
	
	/*
	 * ��ȡsqlSession
	 */
	
	public static SqlSession getSqlSession(){
		
		//�ӵ�ǰ�߳��л�ȡsqlSession
		SqlSession sqlSession = threadLocal.get();
		
		//���sqlSessionΪ��
		if(sqlSession == null){
			
			//����sqlSession
			sqlSession = sessionFactory.openSession();
			//��������sqlSession�͵�ǰ�̰߳�
			threadLocal.set(sqlSession);
		}
		
		return sqlSession;
	}
	
	public static void closeSqlSession(){
		
		SqlSession sqlSession = threadLocal.get();
		
		//�ж��Ƿ�Ϊ��
		if(sqlSession != null){
			
			//�رղ��Ӹ��߳����Ƴ�
			sqlSession.close();
			threadLocal.remove();
		}
		
	}
	
	
	/*public static void main(String[] args) {
		
		Connection connection = MybatisUtil.getSqlSession().getConnection();
		System.out.println(connection);
	}
	*/
}
