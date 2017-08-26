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
		
		//���Ϊע��
		if("register".equals(method)){
			register(request,response);
		}
	}
	
	/**
	 * ע�� ������
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		//��ȡ�������
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//��װ
		Admin admin = new Admin();
		admin.setUserName(userName);
		admin.setPassword(password);		
		//����ҵ���߼�
		
		try {
			is.register(admin);
		} catch (AdminExistsException e) {
			request.setAttribute("msg", "�û�����ע��");
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
