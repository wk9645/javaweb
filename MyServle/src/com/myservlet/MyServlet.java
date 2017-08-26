package com.myservlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/*
	 * 1、tomcat接收到浏览器发送的请求数据，然后封装到HttpServletRequest对象中
	 * 2、tomcat调用doGet方法，然后把request对象传到servlet中
	 * 
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取GET方式的参数
		
		
		/*
		 * 1、获取请求行
		 */
//		String name = request.getHeader("Host");
		
//		System.out.println(request.getMethod()); //请求方式
//		System.out.println(request.getRequestURI()); //请求URI
//		System.out.println(request.getRequestURL());
//		System.out.println(request.getProtocol());
		
		/*
		 * 2、获取请求头
		 */
		
//		System.out.println(request.getHeader("HOST"));  //HOST请求头
		
		//获取所有请求头
		Enumeration<String> heads = request.getHeaderNames();
		while(heads.hasMoreElements()){
			String name = heads.nextElement();
			String headName = request.getHeader(name);
			System.out.println("名字是："+name+":"+headName);
		}
		
		
		
		
		/*
		 * 请求参数
		 */
//		System.out.println(request.getQueryString());
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 请求参数
		 */
//		InputStream in = req.getInputStream();
//		int len = 0;
//		while((len = in.read()) != -1){
//			System.out.println(new String());
//		}
	}

}
