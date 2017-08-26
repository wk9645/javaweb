package com.wk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wk.entity.Admin;
import com.wk.exception.AdminExistsException;
import com.wk.service.IAdminService;
import com.wk.service.ipml.AdminService;

public class AdminServlet extends HttpServlet {
	
	private IAdminService is = new AdminService();
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");
		
		//如果为注册
		if("register".equals(method)){
			register(request,response);
		}
	}
	
	/**
	 * 注册 处理方法
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		//获取请求参数
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//封装
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPassword(password);		
		//调用业务逻辑
		
		try {
			is.register(admin);
		} catch (AdminExistsException e) {
			request.setAttribute("msg", "用户名已注册");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
//			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
