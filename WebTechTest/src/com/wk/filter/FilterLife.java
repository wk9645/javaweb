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
		System.out.println("Filter���󴴽��ɹ�");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
//		System.out.println("filter�����ǣ�"+filterConfig.getFilterName());
//		System.out.println("�����ǣ�"+filterConfig.getInitParameter("key"));
		
		
		System.out.println("Filter�����ʼ����...");
	}
	
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		
		System.out.println("����doFilter�����߼�");
		
		//����
		chain.doFilter(request, response);
	}



	@Override
	public void destroy() {
		
		System.out.println("Filter����������");
	}
	
	
}
