package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 * mybatis获取连接工具类
 * 
 */


public class MybatisUtil {

	
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSessionFactory sessionFactory;
	
	
	static{
		
		Reader reader;
		try {
			//加载配置文件
			reader = Resources.getResourceAsReader("mybatis.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	private MybatisUtil(){}
	
	/*
	 * 获取sqlSession
	 */
	
	public static SqlSession getSqlSession(){
		
		//从当前线程中获取sqlSession
		SqlSession sqlSession = threadLocal.get();
		
		//如果sqlSession为空
		if(sqlSession == null){
			
			//创建sqlSession
			sqlSession = sessionFactory.openSession();
			//将创建的sqlSession和当前线程绑定
			threadLocal.set(sqlSession);
		}
		
		return sqlSession;
	}
	
	public static void closeSqlSession(){
		
		SqlSession sqlSession = threadLocal.get();
		
		//判断是否为空
		if(sqlSession != null){
			
			//关闭并从该线程中移除
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
