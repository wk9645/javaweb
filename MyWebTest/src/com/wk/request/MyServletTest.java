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
		
	//��ȡGET��ʽ�Ĳ���
		
		
		/*
		 * 1����ȡ������
		 */
//		String name = request.getHeader("Host");
		
//		System.out.println(request.getMethod()); //����ʽ
//		System.out.println(request.getRequestURI()); //����URI
//		System.out.println(request.getRequestURL());
//		System.out.println(request.getProtocol());
		
		/*
		 * 2����ȡ����ͷ
		 */
		
//		System.out.println(request.getHeader("HOST"));  //HOST����ͷ
		
		//��ȡ��������ͷ
		/*Enumeration<String> heads = request.getHeaderNames();
		while(heads.hasMoreElements()){
			String name = heads.nextElement();
			String headName = request.getHeader(name);
			System.out.println(name+":"+headName);
		}*/
		
		
		/*
		 * 3����ȡ������ 
		 */
		
				
		/*
		 * 4���������
		 */
		System.out.println(request.getQueryString()); //��ȡ���в���
		
		//��ȡ�����ɽ��в���
		
		
	}
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * �������
		 */
		InputStream in = req.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = in.read(buf)) != -1){
			System.out.println(new String(buf,0,len));
		}
	}

}
