package com.wk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//获取当前执行的方法名
		String methodName = invocation.getProxy().getMethod();
		
		//获取员工对象
		ActionContext ac = invocation.getInvocationContext();
		Object obj = ac.getSession().get("adminInfo");
		//如果不是登陆状态，则不进行验证
		if(!"login".equals(methodName) && !"list".equals(methodName)){
			
			//判断是否已登录
			if(obj == null){
				System.out.println(obj);
				return "login";
			}else {
				return invocation.invoke();
			}
				
		}else {
			return invocation.invoke();
		}
		
	}

}
