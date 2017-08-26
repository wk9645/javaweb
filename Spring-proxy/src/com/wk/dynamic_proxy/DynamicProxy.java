package com.wk.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

	
	private Object target;
	public DynamicProxy(Object target){
		this.target = target;
	}

	
	public Object getInstance(){
		
		return Proxy.newProxyInstance(
							target.getClass().getClassLoader(),
							target.getClass().getInterfaces(),
							new InvocationHandler() {
								
								@Override
								public Object invoke(Object proxy, Method method, Object[] args)
										throws Throwable {
									System.out.println("��������");
									//ִ��Ŀ����󷽷�,���շ���ֵ
									Object returnValue = null;
									
									Method[] methods = target.getClass().getDeclaredMethods();
									for (Method m : methods) {
										if("save".equals(m.getName()))
											returnValue = m.invoke(target, args);
									}
									
									System.out.println("�ύ����");
									return returnValue;
								}
							});
		
		
	}
	
}
