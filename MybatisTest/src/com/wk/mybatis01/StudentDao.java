package com.wk.mybatis01;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import utils.MybatisUtil;

public class StudentDao {

	
	/*
	 *	添加学生
	 */
	@Test
	public void add1(){

		SqlSession sqlSession = null;
		
		try {
			
			//创建SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//事务默认开始
			//执行
			int i = sqlSession.insert("add1");
			
			System.out.println("影响了" + i + "行");
			//事务提交
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}
	
	
	@Test
	public void add2(Student student){
		
		SqlSession sqlSession = null;
		
		try {
			
			//创建SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//事务默认开始
			//执行
			sqlSession.insert(Student.class.getName() + ".add2", student);
			
			//事务提交
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}
	
	
	/*
	 * 查询所有学生
	 */
	public List<Student> findAll(){
		
		SqlSession sqlSession = null;
		
		try {
			
			//创建SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			List<Student> students = sqlSession.selectList(Student.class.getName() + ".findAll");
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}

	/*
	 *	删除学生
	 */
	public void delete(int id){
		
		SqlSession sqlSession = null;
		
		try {
			
			//创建SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//事务默认开始
			//执行
			sqlSession.delete(Student.class.getName() + ".delete", id);
			
			//事务提交
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}
	/*
	 *	更新学生
	 */
	public void update(Student student){
		
		SqlSession sqlSession = null;
		
		try {
			
			//创建SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//事务默认开始
			//执行
			
		
			sqlSession.update(Student.class.getName() + ".update", student);
			
			//事务提交
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}
	
	
	/*
	 * 分页
	 */
	
	public List<Student> findByFy(int start, int size){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			Map<String, Integer> map = new LinkedHashMap<String, Integer>();
			map.put("k_start", start);
			map.put("k_size", size);
			
			return sqlSession.selectList(Student.class.getName() + ".findByFy", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally{

			MybatisUtil.closeSqlSession();
		}
		
		
	}
	
	/*
	 * 动态查询
	 * 
	 */

	public List<Student> findByOption(Integer id, String name, Double salary){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("k_id", id);
			map.put("k_name", "%" + name + "%");
			map.put("k_salary", salary);
			
			return sqlSession.selectList(Student.class.getName() + ".findByOption", map);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally{

			MybatisUtil.closeSqlSession();
		}
		
		
	}
	
	
	/*
	 * 动态更新
	 * 
	 */

	public void updateByOption(Integer id, String name, Double salary){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("k_id", id);
			map.put("k_name", name);
			map.put("k_salary", salary);
			
			int i = sqlSession.update(Student.class.getName() + ".updateByOption", map);
			System.out.println("影响了" + i + "行");
			
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}finally{

			MybatisUtil.closeSqlSession();
		}
		
		
	}
	
	
	/*
	 * 动态删除
	 */

	public void deleteByOption(int...ids){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.delete(Student.class.getName() + ".deleteByOption", ids);
			
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}finally{

			MybatisUtil.closeSqlSession();
		}
		
		
	}
	
	/*
	 * 动态删除
	 */

	public void addByOption(Student student){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.insert(Student.class.getName() + ".addByOption", student);
			
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException();
		}finally{

			MybatisUtil.closeSqlSession();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		StudentDao dao = new StudentDao();
		
		//1、添加
		/*List<Student> students = dao.findAll();
		for(Student student : students){
			System.out.println(student);
		}*/
		
		
//		dao.add2(new Student(i, "小明" + i, 5000));
			
		//2、删除
//		dao.delete(1);
		
		//3、更新
//		dao.update(new Student(2,"哈哈",6000));
		
		//4、分页查询
		/*System.out.println("第一页");
		List<Student> stus1 = dao.findByFy(0, 3);
		for (Student student : stus1) {
			System.out.println(student);
		}
		System.out.println("第二页");
		List<Student> stus2 = dao.findByFy(3, 3);
		for (Student student : stus2) {
			System.out.println(student);
		}
		System.out.println("第三页");
		List<Student> stus3 = dao.findByFy(6, 3);
		for (Student student : stus3) {
			System.out.println(student);
		}
		System.out.println("第四页");
		List<Student> stus4 = dao.findByFy(9, 3);
		for (Student student : stus4) {
			System.out.println(student);
		}
		*/
		
		//5、动态查询
		/*List<Student> list = dao.findByOption(null, "小明", 5000d);
		
		for (Student student : list) {
			
			System.out.println(student);
		}*/
		
		
		//6、动态更新
		
//		dao.updateByOption(10,"小明",null);
		
		//7、动态删除
		
//		dao.deleteByOption(5,6,7);
		
		//8、动态增加
		
		dao.addByOption(new Student(15,"迪迦奥特曼",8000d));
		
		
	}
	
}
