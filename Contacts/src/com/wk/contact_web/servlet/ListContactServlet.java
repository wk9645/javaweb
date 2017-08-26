package com.wk.contact_web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wk.contact.service.ContactService;
import com.wk.contact.service.ContactServiceImpl;
import com.wk.contact_web.entity.Contact;

public class ListContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.��xml�ж�ȡ����ϵ������
		ContactService service = new ContactServiceImpl();
		List<Contact> list = service.findAll();
		
		//2.�ѽ�����浽�������
		request.setAttribute("contacts", list);
		
		//3.��ת��jspҳ��
		request.getRequestDispatcher("/listContact.jsp").forward(request, response);		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
