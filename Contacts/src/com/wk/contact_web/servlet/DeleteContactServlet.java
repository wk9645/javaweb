package com.wk.contact_web.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wk.contact.service.ContactService;
import com.wk.contact.service.ContactServiceImpl;

public class DeleteContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ڻ�����������Get��ʽ�ύ�����������ݣ����ظ��ύ���Ρ�
		System.out.println("ɾ����ϵ��");
		//1.����id
		String id = request.getParameter("id");
		
		//2.����serviceɾ����ϵ�˵ķ���
		ContactService service = new ContactServiceImpl();
		service.deleteContact(id);
		
		//3.��ת����ѯ��ϵ�˵�ҳ��
		response.sendRedirect(request.getContextPath()+"/ListContactServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
