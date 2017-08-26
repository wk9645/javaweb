package com.wk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.activation.FileDataSource;

import org.junit.Test;

public class Reflect {
	
	
	/*
	 *  获取类对象 
	 * 
	 */
	
	
	@Test
	public void test1() throws Exception{

	
		//1、得到类字节码，然后通过默认构造方法创建对象
		
		String className = "com.wk.reflect.Admin";
		
		Class<?> clazz = Class.forName(className);
//		Admin admin = (Admin) clazz.newInstance();
		
//		Admin admin = Admin.class.newInstance();
		
		
		
	
		//2、通过构造器创建
		
		
		//无参构造方法
//		Constructor<?> constructor = clazz.getDeclaredConstructor();
		
		//有参构造方法
		Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
		Admin admin = (Admin) constructor.newInstance("四娃");
		System.out.println(admin);
		
	}
	
	
	
	/*
	 * 
	 * 	获取类的属性
	 * 
	 */
	@Test
	public void test2() throws Exception{
		
		String className = "com.wk.reflect.Admin";
		Class<?> clazz = Class.forName(className);	
		
		Admin admin = (Admin) clazz.newInstance();
		
		Field[] fds = clazz.getDeclaredFields();
		
		for (Field field : fds) {
			
			//设置强制访问
			field.setAccessible(true);
			String attr = field.getName();
			Object value = field.get(admin);
			
			System.out.println(attr+"--"+value);
		}
	}
	
	
	/*
	 * 
	 * 获取类的方法
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
