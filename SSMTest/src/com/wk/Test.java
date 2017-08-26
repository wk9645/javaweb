package com.wk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wk.entity.Student;
import com.wk.service.StudentService;

public class Test {

	public static void main(String[] args) {
		
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		StudentService service = (StudentService) ac.getBean("studentService");
		service.register(new Student(1,"wk",45d));
		
	}
	
}
