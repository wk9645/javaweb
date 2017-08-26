package com.wk.static_proxy;


public class UserDao implements IUserDao{

	@Override
	public void save() {
		
		System.out.println("±£´æ³É¹¦£¡");
	}
}
