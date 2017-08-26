package com.wk.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wk.entity.DishType;
import com.wk.factory.BeanFactory;
import com.wk.service.IDishTypeService;

/**
 * 菜系管理servlet开发
 * 
 * @author wk
 * 
 */

public class DishTypeServlet extends HttpServlet {

	// 调用的菜系service

	private IDishTypeService service = BeanFactory.getInstance(
			"dishTypeService", IDishTypeService.class);
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html;utf-8");
		String method = request.getParameter("method");

		if ("addDishType".equals(method)) {
			addDishType(request, response);
		} else if ("list".equals(method)) {
			list(request, response);
		} else if ("viewUpdate".equals(method)) {
			viewUpdate(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("update".equals(method)) {
			update(request, response);
		}

	}

	/*
	 * 添加菜系
	 */
	public void addDishType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取请求数据封装
		try {
			String dishTypeName = request.getParameter("dishTypeName");

			DishType dishType = new DishType();
			dishType.setTypeName(dishTypeName);
			service.save(dishType);

			// 跳转
			uri = "/DishTypeServlet?method=list";
			// list(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// 转发
		request.getRequestDispatcher(uri).forward(request, response);
	}

	/*
	 * 菜系列表
	 */
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<DishType> dishs = service.getAll();
			// 放在request域中
			request.setAttribute("listFoodType", dishs);

			// 跳转到菜系页面
			uri = "/sys/type/foodtype_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// 转发
		request.getRequestDispatcher(uri).forward(request, response);

	}

	/*
	 * 进入更新页面
	 */
	public void viewUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// 获取id
			int id = Integer.parseInt(request.getParameter("id"));
			// 调用业务逻辑更新方法
			DishType dishType = service.findById(id);
			request.setAttribute("dishType", dishType);

			uri = "/sys/type/foodtype_update.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// 转发
		request.getRequestDispatcher(uri).forward(request, response);
	}

	/*
	 * 删除菜系
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			service.delete(id);

			uri = "/DishTypeServlet?method=list";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// 转发
		// request.getRequestDispatcher(uri).forward(request,response);
		response.sendRedirect(request.getContextPath() + uri);

	}

	/*
	 * 更新菜系
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String typeName = request.getParameter("typeName");
			int id = Integer.parseInt(request.getParameter("id"));
			DishType dt = new DishType();
			dt.setId(id);
			dt.setTypeName(typeName);
			service.update(dt);

			uri = "/DishTypeServlet?method=list";

		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// 转发
		// request.getRequestDispatcher(uri).forward(request,response);
		response.sendRedirect(request.getContextPath() + uri);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
