package com.wk.ajax;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AJAX3 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=ustf-8");
		
		/*
		 * 判断输入名称是否已经存在
		 */
		
		String name = request.getParameter("userName");
//		String tip = "image/MsgSent.gif";
		
		/*
		 * 写入
		 */
		InputStream is = null;
//		PrintStream ps = null;
		
		is = AJAX3.class.getResourceAsStream("/image/MsgSent.gif");
		ServletOutputStream os = response.getOutputStream();
		if("wk".equals(name)){
			
			is = AJAX3.class.getResourceAsStream("/image/MsgError.gif");
		}
		
		int len = 0;
		while((len = is.read()) != -1){
			os.write(len);
		}
		
		os.close();
		is.close();
	}

}
