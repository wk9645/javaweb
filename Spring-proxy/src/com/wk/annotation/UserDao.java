package com.wk.annotation;

import org.springframework.stereotype.Component;

@Component       //��UserDao��������
public class UserDao{

	public void save() {
		
		System.out.println("����ɹ���");
	}
}
