package com.wk.test1;

public class ObjectFactory {

	public User getInstance(){
		
		return new User(100, "工厂调用实例方法");
		
	}
	
	public static User getStaticInstance(){
		
		return new User(200, "工厂调用静态方法");
		
	}
}
