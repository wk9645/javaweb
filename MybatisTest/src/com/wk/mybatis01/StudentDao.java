package com.wk.mybatis01;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import utils.MybatisUtil;

public class StudentDao {

	
	/*
	 *	���ѧ��
	 */
	@Test
	public void add1(){

		SqlSession sqlSession = null;
		
		try {
			
			//����SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//����Ĭ�Ͽ�ʼ
			//ִ��
			int i = sqlSession.insert("add1");
			
			System.out.println("Ӱ����" + i + "��");
			//�����ύ
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
			
			//����SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//����Ĭ�Ͽ�ʼ
			//ִ��
			sqlSession.insert(Student.class.getName() + ".add2", student);
			
			//�����ύ
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}
	
	
	/*
	 * ��ѯ����ѧ��
	 */
	public List<Student> findAll(){
		
		SqlSession sqlSession = null;
		
		try {
			
			//����SqlSession
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
	 *	ɾ��ѧ��
	 */
	public void delete(int id){
		
		SqlSession sqlSession = null;
		
		try {
			
			//����SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//����Ĭ�Ͽ�ʼ
			//ִ��
			sqlSession.delete(Student.class.getName() + ".delete", id);
			
			//�����ύ
			sqlSession.commit();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw new RuntimeException();
		}finally{
			
			MybatisUtil.closeSqlSession();
		}
		
	}
	/*
	 *	����ѧ��
	 */
	public void update(Student student){
		
		SqlSession sqlSession = null;
		
		try {
			
			//����SqlSession
			sqlSession = MybatisUtil.getSqlSession();
			//����Ĭ�Ͽ�ʼ
			//ִ��
			
		
			sqlSession.update(Student.class.getName() + ".update", student);
			
			//�����ύ
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
	 * ��ҳ
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
	 * ��̬��ѯ
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
	 * ��̬����
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
			System.out.println("Ӱ����" + i + "��");
			
			//�ύ����
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
	 * ��̬ɾ��
	 */

	public void deleteByOption(int...ids){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.delete(Student.class.getName() + ".deleteByOption", ids);
			
			//�ύ����
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
	 * ��̬ɾ��
	 */

	public void addByOption(Student student){
		
		SqlSession sqlSession = null;
		
		try {
			
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.insert(Student.class.getName() + ".addByOption", student);
			
			//�ύ����
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
		
		//1�����
		/*List<Student> students = dao.findAll();
		for(Student student : students){
			System.out.println(student);
		}*/
		
		
//		dao.add2(new Student(i, "С��" + i, 5000));
			
		//2��ɾ��
//		dao.delete(1);
		
		//3������
//		dao.update(new Student(2,"����",6000));
		
		//4����ҳ��ѯ
		/*System.out.println("��һҳ");
		List<Student> stus1 = dao.findByFy(0, 3);
		for (Student student : stus1) {
			System.out.println(student);
		}
		System.out.println("�ڶ�ҳ");
		List<Student> stus2 = dao.findByFy(3, 3);
		for (Student student : stus2) {
			System.out.println(student);
		}
		System.out.println("����ҳ");
		List<Student> stus3 = dao.findByFy(6, 3);
		for (Student student : stus3) {
			System.out.println(student);
		}
		System.out.println("����ҳ");
		List<Student> stus4 = dao.findByFy(9, 3);
		for (Student student : stus4) {
			System.out.println(student);
		}
		*/
		
		//5����̬��ѯ
		/*List<Student> list = dao.findByOption(null, "С��", 5000d);
		
		for (Student student : list) {
			
			System.out.println(student);
		}*/
		
		
		//6����̬����
		
//		dao.updateByOption(10,"С��",null);
		
		//7����̬ɾ��
		
//		dao.deleteByOption(5,6,7);
		
		//8����̬����
		
		dao.addByOption(new Student(15,"���Ȱ�����",8000d));
		
		
	}
	
}
