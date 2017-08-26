package com.wk.springmvc02;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class EmpAction extends AbstractCommandController{

	
	public EmpAction(){
		
		this.setCommandClass(Emptyee.class);
	}
	
	/*
	 * 日期转换
	 */
	

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(Date.class, 
					new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		
	}
	
	/*
	 * obj表示表单属性封装后的对象
	 */
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object obj, BindException error)
			throws Exception {
		ModelAndView m = new ModelAndView();
		
		Emptyee emptyee = (Emptyee) obj;
		
		System.out.println("姓名：" + emptyee.getUserName());
		System.out.println("性别：" + emptyee.getGender());
		System.out.println("入职时间：" + emptyee.getWorkDate().toString());
		
		m.addObject("emp", emptyee);
		m.setViewName("index");
		
		return m;
	}

}
