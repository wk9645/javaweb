package com.wk.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wk.entity.Student;
import com.wk.service.StudentService;



@Controller
@RequestMapping(value="/student")
public class StudentAction {

	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value="/register.action",method=RequestMethod.POST)
	public String register(Student stu) throws Exception{	
		
		studentService.register(stu);
		
		return "/success.jsp";
	}
	
}
