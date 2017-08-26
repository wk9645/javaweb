package com.wk.springmvc03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 使用注解方式
 */


//指定为控制器
@Controller
public class HelloAction {
	
	public HelloAction(){
		System.out.println("................");
	}
	
	/**
	 * 业务方法
	 * @param model		用于封装数据
	 * @return			返回视图路径名
	 * @throws Exception
	 */
	//指定拦截"/hello.action"的请求
	@RequestMapping(value="/hello.action")   
	public String hello(Model model) throws Exception{
		System.out.println("HelloAction::hello()");
		model.addAttribute("message","你好");
		return "/success.jsp";
	}
	

	@RequestMapping(value="/bye.action")   
	public String bye(Model model) throws Exception{
		System.out.println("HelloAction::hello()");
		model.addAttribute("message","再见");
		return "/success.jsp";
	}
	
}
