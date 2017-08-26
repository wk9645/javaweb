package com.wk.service;

import com.wk.dao.StudentDao;
import com.wk.entity.Student;

public class StudentService {

	
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void register(Student stu){
		
		studentDao.add(stu);
		
	}
	
}
