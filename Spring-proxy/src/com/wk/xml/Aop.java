package com.wk.xml;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



/*
 * 
 * Aop������
 */

public class Aop {
	
	public void begin(){
	
		System.out.println("��ʼ����");
	}
	
	public void commit(){
		
		System.out.println("�ύ����");
	}
	
}
