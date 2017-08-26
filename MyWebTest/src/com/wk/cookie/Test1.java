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

		//创建你Cookie对象
		Cookie cookie = new Cookie("name","zhangsan");
		//添加
		response.addCookie(cookie);
		System.out.println("添加Cookie成功");
		
		//从服务器返回到浏览器
		
		
		Cookie[] cookies = request.getCookies();
		for(Cookie item : cookies){
			String name = item.getName();
			String value = item.getValue();
			System.out.println(name+"="+value);
		}
		
	}

}
