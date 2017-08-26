package com.wk.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class FilterLife implements Filter{

	
	public FilterLife() {
		System.out.println("Filter对象创建成功");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
//		System.out.println("filter名字是："+filterConfig.getFilterName());
//		System.out.println("参数是："+filterConfig.getInitParameter("key"));
		
		
		System.out.println("Filter对象初始化中...");
	}
	
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		System.out.println("处理doFilter方法逻辑");
		
		//放行
		chain.doFilter(request, response);
	}



	@Override
	public void destroy() {
		
		System.out.println("Filter对象已销毁");
	}
	
	
}
