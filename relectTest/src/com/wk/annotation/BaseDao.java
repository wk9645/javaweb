package com.wk.annotation;

/**
 * 
 * 当查找数据库数据时：
 * 		1、Javabean的类名与数据库的表名不一致
 * 		2、类的属性和表中的字段不一致
 * 		3、类中没有和表中额度主键相同的属性时
 * 
 * 此时可以使用xml配置，也可以用注解
 * @author asus
 *
 */
public class BaseDao<T> {

	
	private Class clazz;
	private String className;
	
	//构造方法中获取参数化类型
	public BaseDao(){
		
		
		
		
	}
	
}
