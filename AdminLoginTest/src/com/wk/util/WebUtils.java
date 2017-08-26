package com.wk.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.validator.util.NewInstance;
import org.junit.Test;

import com.wk.entity.Admin;

public class WebUtils {
	
	@Test
	public static Admin copyToBean_old(HttpServletRequest request, Class<Admin> clazz) throws Exception{
		
		Admin admin = Admin.class.newInstance();
		Enumeration<String> enums = request.getParameterNames();
		
		try {
			while(enums.hasMoreElements()){
				String name = enums.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(admin, name, value);
				
			}
			return admin;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	
	
	

	/**
	 * 处理请求数据的封装
	 */
	/*public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		try {
			// （注册日期类型转换器）
			// 创建对象
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/
}
