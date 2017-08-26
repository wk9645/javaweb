package com.wk.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 extends HttpServlet {

	String lastTimeVal;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gbk");
		
		Date date = new Date();
		String time = date.toLocaleString();
		Cookie[] cookie = request.getCookies();
		if(cookie != null){
			for(Cookie item : cookie){
				if("lastTime".equals(item.getName())){
					lastTimeVal = item.getValue();
					response.getWriter().write("您上次访问时间为："+lastTimeVal+"当前时间为："+time);
				}
			}
		}
		
		Cookie newCookie = new Cookie("lastTime", time);
		response.addCookie(newCookie);
		
	}

}
