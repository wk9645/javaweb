package com.wk.springmvc01;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


/*
 * ������
 */

public class HelloAction implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		//����ModelAndView����������ͼ��װ���ݺ�·��
		ModelAndView modelAndView = new ModelAndView();
		
		//��װ����
//		modelAndView.addObject("msg", "hello world!");
	
		//��װ·��,��һ��/ָwebapp��Ŀ¼
//		modelAndView.setViewName("/success.jsp");
		//ֱ��ʹ�÷�����ͼ��
		modelAndView.setViewName("success");
		
		return modelAndView;
	}
	
}
