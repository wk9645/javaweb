package com.wk.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



/*
 * 
 * Aop切面类
 */
@Component
@Aspect    //指定该类为切面类
public class Aop {
	//指定切入点表达式：拦截的方法，即为那些类生成代理对象
	//..代表参数
	@Pointcut("execution(* com.wk.annotation.*.*(..))")         
	public void pointCut_(){};
	
	
	
	@Before("pointCut_()")                //前置通知：在执行目标方法之前执行
	public void begin(){
	
		System.out.println("开始事务");
	}
	
	@After("pointCut_()")                   //后置通知：在执行目标方法之后执行
	public void commit(){
		
		System.out.println("提交事务");
	}
	
	
}
