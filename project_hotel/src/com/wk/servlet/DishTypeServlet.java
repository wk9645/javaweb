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
 * ��ϵ����servlet����
 * 
 * @author wk
 * 
 */

public class DishTypeServlet extends HttpServlet {

	// ���õĲ�ϵservice

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
	 * ��Ӳ�ϵ
	 */
	public void addDishType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�������ݷ�װ
		try {
			String dishTypeName = request.getParameter("dishTypeName");

			DishType dishType = new DishType();
			dishType.setTypeName(dishTypeName);
			service.save(dishType);

			// ��ת
			uri = "/DishTypeServlet?method=list";
			// list(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// ת��
		request.getRequestDispatcher(uri).forward(request, response);
	}

	/*
	 * ��ϵ�б�
	 */
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<DishType> dishs = service.getAll();
			// ����request����
			request.setAttribute("listFoodType", dishs);

			// ��ת����ϵҳ��
			uri = "/sys/type/foodtype_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// ת��
		request.getRequestDispatcher(uri).forward(request, response);

	}

	/*
	 * �������ҳ��
	 */
	public void viewUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// ��ȡid
			int id = Integer.parseInt(request.getParameter("id"));
			// ����ҵ���߼����·���
			DishType dishType = service.findById(id);
			request.setAttribute("dishType", dishType);

			uri = "/sys/type/foodtype_update.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri = "/error/error.jsp";
		}

		// ת��
		request.getRequestDispatcher(uri).forward(request, response);
	}

	/*
	 * ɾ����ϵ
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

		// ת��
		// request.getRequestDispatcher(uri).forward(request,response);
		response.sendRedirect(request.getContextPath() + uri);

	}

	/*
	 * ���²�ϵ
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

		// ת��
		// request.getRequestDispatcher(uri).forward(request,response);
		response.sendRedirect(request.getContextPath() + uri);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
