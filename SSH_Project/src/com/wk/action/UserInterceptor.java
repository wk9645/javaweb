package com.wk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//��ȡ��ǰִ�еķ�����
		String methodName = invocation.getProxy().getMethod();
		
		//��ȡԱ������
		ActionContext ac = invocation.getInvocationContext();
		Object obj = ac.getSession().get("adminInfo");
		//������ǵ�½״̬���򲻽�����֤
		if(!"login".equals(methodName) && !"list".equals(methodName)){
			
			//�ж��Ƿ��ѵ�¼
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
