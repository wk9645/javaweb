package com.wk.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HelloInterceptor implements Interceptor{

	public HelloInterceptor() {
		System.out.println("������HelloIterceptor������");
	}
	
	@Override
	public void init() {
		
		System.out.println("��ʼ��������");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("������ҵ��������ʼ......");
		
		
		//ִ����Ϻ�ʼ��һ����������ִ�У�����ִ��Action
		
		//����Action�Ľ��
		String result = invocation.invoke();
		
		System.out.println("������ҵ�������");
		return result;
	}

	@Override
	public void destroy() {

		System.out.println("����������");
	}
}
