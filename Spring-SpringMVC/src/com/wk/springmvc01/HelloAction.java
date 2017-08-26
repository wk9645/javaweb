package com.wk.springmvc01;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/*
 * 控制器
 */

public class HelloAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		//创建ModelAndView对象，用于视图封装数据和路径
		ModelAndView modelAndView = new ModelAndView();
		
		//封装数据
//		modelAndView.addObject("msg", "hello world!");
	
		//封装路径,第一个/指webapp根目录
//		modelAndView.setViewName("/success.jsp");
		//直接使用返回视图名
		modelAndView.setViewName("success");
		
		return modelAndView;
	}
	
}
