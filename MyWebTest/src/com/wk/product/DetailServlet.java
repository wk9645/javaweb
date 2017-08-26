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
		html +="<title>显示商品列表</title>";
		html +="</head>";
		html +="<body>";
		html +="<table border='1' align='center' width='300px'>";
		//遍历商品
		if(product!=null){
			
			html +="<tr><th>编号:</th><td>"+product.getId()+"</td></tr>";
			html +="<tr><th>商品名称:</th><td>"+product.getProName()+"</td></tr>";
			html +="<tr><th>商品型号:</th><td>"+product.getProType()+"</td></tr>";
			html +="<tr><th>商品价格:</th><td>"+product.getProPrice()+"</td></tr>";
			
		}
		html +="</table>";
		html +="<center><a href='"+request.getContextPath()+"/ListServlet'>[返回列表]</a></center>";
		html +="</body>";
		html +="</html>";
		
		writer.write(html);
		
		/*
		 * 创建Cookie
		 */
		
			Cookie cookie = new Cookie("history", createValue(request, id));
			cookie.setMaxAge(1*30*24*60*60); //一个月
			response.addCookie(cookie);
		
		
			
	}
	
	/*
	 * 
	 * 生成cookie信息
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
		//cookies为空或者浏览历史为空
		if(cookies == null || history == null){
			return id;
		}
		//使用集合判断可以正确判断元素是否重复
		String[] ids = history.split(",");
		Collection collection = Arrays.asList(ids);
		LinkedList<String> list = new LinkedList<String>(collection);
		//不超过3个
		if(list.size() < 3){
			//id重复
			if(collection.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else {
				//不重复
				list.addFirst(id);
			}
		}
			//超过3个
		else{
			//id重复
			if(collection.contains(id)){
				list.remove(id);
				list.addFirst(id);
			}else {
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		//将集合转换为字符串
		StringBuffer sb = new StringBuffer();
		for (String item : list) {
			sb.append(item+",");
		}
		String result = sb.toString();
		result = result.substring(0,result.length()-1);
		return result;
	}

}
