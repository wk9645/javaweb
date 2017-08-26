package com.wk.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wk.entity.Admin;
import com.wk.util.WebUtils;

public class AdminLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//使用WebUtils工具类
		
		try {
			Admin admin2 = WebUtils.copyToBean_old(req, Admin.class);
			System.out.println(admin2);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		String name = req.getParameter("userName");
//		String password = req.getParameter("password");
		
		//获取所有参数
		//Enumeration<String> enums = req.getParameterNames();
		
		/*try {
			while(enums.hasMoreElements()){
				String name = enums.nextElement();
				String psw = req.getParameter(name);
				BeanUtils.setProperty(admin, name, psw);
			
//				System.out.println(name+"-"+psw);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
				
	}
}
