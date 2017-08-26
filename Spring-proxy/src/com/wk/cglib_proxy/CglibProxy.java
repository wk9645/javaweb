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
		
		//创建工具
		Enhancer en = new Enhancer();
		//设置父类
		en.setSuperclass(target.getClass());
		//设置回调函数
		en.setCallback(this);
		//创建子类
		return en.create();
	}


	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		
		System.out.println("开始事务");
		Object result = method.invoke(target, args);
		System.out.println("提交事务");
		return result;
	}
	
	
}
