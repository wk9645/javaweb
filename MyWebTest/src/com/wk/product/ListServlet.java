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
	 * 用于查询所有商品的servlet
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取数据
		ProductDao dao = new ProductDao();
		List<Product> list = dao.findAll();
		
		//把商品显示在浏览器中
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		String html = "";
		html +="<html>";
		html +="<head>";
		html +="<title>显示商品列表</title>";
		html +="</head>";
		html +="<body>";
		html +="<table border='3' align='center' width='300px'>";
		html +="<tr>";
		html +="<th>编号</th><th>商品名称</th><th>商品型号</th><th>商品价格</th>";
		html +="</tr>";
		//遍历商品
		if(list!=null){
			for (Product p : list) {
				html +="<tr>";
				//访问DetailSevlet，并传递id为1的参数
				html +="<td>"+p.getId()+"</td><td><a href='"+request.getContextPath()+"/DetailServlet?id="+p.getId()+"'>"+p.getProName()+"</a></td><td>"+p.getProType()+"</td><td>"+p.getProPrice()+"</td>";
				html +="</tr>";
				
			}
		}
		
		
		html +="最近浏览过的商品<br/>";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("history")){
					String value = cookie.getValue();
					String[] ids = value.split(",");
					for (String id : ids) {
						//根据id取出商品
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
