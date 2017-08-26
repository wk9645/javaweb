package com.wk.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



/*
 * 
 * Aop������
 */
@Component
@Aspect    //ָ������Ϊ������
public class Aop {
	//ָ���������ʽ�����صķ�������Ϊ��Щ�����ɴ������
	//..�������
	@Pointcut("execution(* com.wk.annotation.*.*(..))")         
	public void pointCut_(){};
	
	
	
	@Before("pointCut_()")                //ǰ��֪ͨ����ִ��Ŀ�귽��֮ǰִ��
	public void begin(){
	
		System.out.println("��ʼ����");
	}
	
	@After("pointCut_()")                   //����֪ͨ����ִ��Ŀ�귽��֮��ִ��
	public void commit(){
		
		System.out.println("�ύ����");
	}
	
	
}
