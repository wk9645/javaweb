package com.wk.cglib_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	private Object target;
	public CglibProxy(Object target){
		this.target = target;
	}
	
	
	public Object getInstance(){
		
		//��������
		Enhancer en = new Enhancer();
		//���ø���
		en.setSuperclass(target.getClass());
		//���ûص�����
		en.setCallback(this);
		//��������
		return en.create();
	}


	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		System.out.println("��ʼ����");
		Object result = method.invoke(target, args);
		System.out.println("�ύ����");
		return result;
	}
	
	
}
