package com.wk.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

	
	/*
	 *
	 * ���ڲ�ѯ������Ʒ��servlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��ȡ����
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAll();
		
		//����Ʒ��ʾ���������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String html = "";
		html +="<html>";
		html +="<head>";
		html +="<title>��ʾ��Ʒ�б�</title>";
		html +="</head>";
		html +="<body>";
		html +="<table border='3' align='center' width='300px'>";
		html +="<tr>";
		html +="<th>���</th><th>��Ʒ����</th><th>��Ʒ�ͺ�</th><th>��Ʒ�۸�</th>";
		html +="</tr>";
		//������Ʒ
		if(list!=null){
			for (Product p : list) {
				html +="<tr>";
				//����DetailSevlet��������idΪ1�Ĳ���
				html +="<td>"+p.getId()+"</td><td><a href='"+request.getContextPath()+"/DetailServlet?id="+p.getId()+"'>"+p.getProName()+"</a></td><td>"+p.getProType()+"</td><td>"+p.getProPrice()+"</td>";
				html +="</tr>";
				
			}
		}
		
		
		html +="������������Ʒ<br/>";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("history")){
					String value = cookie.getValue();
					String[] ids = value.split(",");
					for (String id : ids) {
						//����idȡ����Ʒ
						Product p = dao.findById(id);
						html +=""+p.getId()+"&nbsp;"+p.getProName()+"&nbsp;"+p.getProPrice()+"<br/>";
						
					}
				}
				
			}
		}
		
		html +="</table>";
		html +="</body>";
		html +="</html>";
		
		writer.write(html);
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
	}
}
