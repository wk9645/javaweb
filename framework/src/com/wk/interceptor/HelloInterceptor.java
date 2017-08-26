package com.wk.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class HelloInterceptor implements Interceptor{

	public HelloInterceptor() {
		System.out.println("创建了HelloIterceptor拦截器");
	}
	
	@Override
	public void init() {
		
		System.out.println("初始化拦截器");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("拦截器业务处理方法开始......");
		
		
		//执行完毕后开始下一个拦截器的执行，或者执行Action
		
		//返回Action的结果
		String result = invocation.invoke();
		
		System.out.println("拦截器业务处理结束");
		return result;
	}

	@Override
	public void destroy() {

		System.out.println("拦截器销毁");
	}
}
