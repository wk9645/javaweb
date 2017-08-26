package com.wk.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -728346652505925577L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		ProductDao dao = new ProductDao();
		Product product = dao.findById(id);
		String html = "";
		html +="<html>";
		html +="<head>";
		html +="<title>��ʾ��Ʒ�б�</title>";
		html +="</head>";
		html +="<body>";
		html +="<table border='1' align='center' width='300px'>";
		//������Ʒ
		if(product!=null){
			
			html +="<tr><th>���:</th><td>"+product.getId()+"</td></tr>";
			html +="<tr><th>��Ʒ����:</th><td>"+product.getProName()+"</td></tr>";
			html +="<tr><th>��Ʒ�ͺ�:</th><td>"+product.getProType()+"</td></tr>";
			html +="<tr><th>��Ʒ�۸�:</th><td>"+product.getProPrice()+"</td></tr>";
			
		}
		html +="</table>";
		html +="<center><a href='"+request.getContextPath()+"/ListServlet'>[�����б�]</a></center>";
		html +="</body>";
		html +="</html>";
		
		writer.write(html);
		
		/*
		 * ����Cookie
		 */
		
			Cookie cookie = new Cookie("history", createValue(request, id));
			cookie.setMaxAge(1*30*24*60*60); //һ����
			response.addCookie(cookie);
		
		
			
	}
	
	/*
	 * 
	 * ����cookie��Ϣ
	 */
	
	private String createValue(HttpServletRequest request,String id){
		Cookie[] cookies = request.getCookies();
		String history = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("history")){
					history = cookie.getValue();
					break;
				}
			}
		}
		//cookiesΪ�ջ��������ʷΪ��
		if(cookies == null || history == null){
			return id;
		}
		//ʹ�ü����жϿ�����ȷ�ж�Ԫ���Ƿ��ظ�
		String[] ids = history.split(",");
		Collection collection = Arrays.asList(ids);
		LinkedList<String> list = new LinkedList<String>(collection);
		//������3��
		if(list.size() < 3){
			//id�ظ�
			if(collection.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else {
				//���ظ�
				list.addFirst(id);
			}
		}
			//����3��
		else{
			//id�ظ�
			if(collection.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else {
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		//������ת��Ϊ�ַ���
		StringBuffer sb = new StringBuffer();
		for (String item : list) {
			sb.append(item+",");
		}
		String result = sb.toString();
		result = result.substring(0,result.length()-1);
		return result;
	}

}
