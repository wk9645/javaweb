package com.wk.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//������Cookie����
		Cookie cookie = new Cookie("name","zhangsan");
		//���
		response.addCookie(cookie);
		System.out.println("���Cookie�ɹ�");
		
		//�ӷ��������ص������
		
		
		Cookie[] cookies = request.getCookies();
		for(Cookie item : cookies){
			String name = item.getName();
			String value = item.getValue();
			System.out.println(name+"="+value);
		}
		
	}

}
