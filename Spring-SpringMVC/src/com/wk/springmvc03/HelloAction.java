package com.wk.springmvc03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * ʹ��ע�ⷽʽ
 */


//ָ��Ϊ������
@Controller
public class HelloAction {
	
	public HelloAction(){
		System.out.println("................");
	}
	
	/**
	 * ҵ�񷽷�
	 * @param model		���ڷ�װ����
	 * @return			������ͼ·����
	 * @throws Exception
	 */
	//ָ������"/hello.action"������
	@RequestMapping(value="/hello.action")   
	public String hello(Model model) throws Exception{
		System.out.println("HelloAction::hello()");
		model.addAttribute("message","���");
		return "/success.jsp";
	}
	

	@RequestMapping(value="/bye.action")   
	public String bye(Model model) throws Exception{
		System.out.println("HelloAction::hello()");
		model.addAttribute("message","�ټ�");
		return "/success.jsp";
	}
	
}
