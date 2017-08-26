package com.wk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.activation.FileDataSource;

import org.junit.Test;

public class Reflect {
	
	
	/*
	 *  ��ȡ����� 
	 * 
	 */
	
	
	@Test
	public void test1() throws Exception{

	
		//1���õ����ֽ��룬Ȼ��ͨ��Ĭ�Ϲ��췽����������
		
		String className = "com.wk.reflect.Admin";
		
		Class<?> clazz = Class.forName(className);
//		Admin admin = (Admin) clazz.newInstance();
		
//		Admin admin = Admin.class.newInstance();
		
		
		
	
		//2��ͨ������������
		
		
		//�޲ι��췽��
//		Constructor<?> constructor = clazz.getDeclaredConstructor();
		
		//�вι��췽��
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
		Admin admin = (Admin) constructor.newInstance("����");
		System.out.println(admin);
		
	}
	
	
	
	/*
	 * 
	 * 	��ȡ�������
	 * 
	 */
	@Test
	public void test2() throws Exception{
		
		String className = "com.wk.reflect.Admin";
		Class<?> clazz = Class.forName(className);	
		
		Admin admin = (Admin) clazz.newInstance();
		
		Field[] fds = clazz.getDeclaredFields();
		
		for (Field field : fds) {
			
			//����ǿ�Ʒ���
			field.setAccessible(true);
			String attr = field.getName();
			Object value = field.get(admin);
			
			System.out.println(attr+"--"+value);
		}
	}
	
	
	/*
	 * 
	 * ��ȡ��ķ���
	 */
	@Test
	public void test3() throws Exception{
		
		String className = "com.wk.reflect.Admin";
		Class<?> clazz = Class.forName(className);	
		
		Admin admin = (Admin) clazz.newInstance();
		
		Method m = clazz.getDeclaredMethod("getName");
		Object value = m.invoke(admin);
		
		System.out.println(value);
		
	}
	
}
