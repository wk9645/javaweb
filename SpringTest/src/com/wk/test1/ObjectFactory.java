package com.wk.test1;

public class ObjectFactory {

	public User getInstance(){
		
		return new User(100, "��������ʵ������");
		
	}
	
	public static User getStaticInstance(){
		
		return new User(200, "�������þ�̬����");
		
	}
}
