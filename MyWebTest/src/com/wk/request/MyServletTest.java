package com.wk.request;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletTest extends HttpServlet {

	
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
		/*Enumeration<String> heads = request.getHeaderNames();
		while(heads.hasMoreElements()){
			String name = heads.nextElement();
			String headName = request.getHeader(name);
			System.out.println(name+":"+headName);
		}*/
		
		
		/*
		 * 3、获取请求体 
		 */
		
				
		/*
		 * 4、请求参数
		 */
		System.out.println(request.getQueryString()); //获取所有参数
		
		//获取参数可进行操作
		
		
	}
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 请求参数
		 */
		InputStream in = req.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = in.read(buf)) != -1){
			System.out.println(new String(buf,0,len));
		}
	}

}
