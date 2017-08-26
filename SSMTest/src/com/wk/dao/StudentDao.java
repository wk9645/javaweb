package com.wk.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wk.entity.Student;

public class StudentDao {

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public void add(Student stu){
		
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("com.wk.entity.Student.add",stu);
	
	}
}
