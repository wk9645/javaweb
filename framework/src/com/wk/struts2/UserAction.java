package com.wk.struts2;

import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{

	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String register(){

		System.out.println("name:"+user.getName());
		System.out.println("pwd:"+user.getPwd());
		System.out.println("age:"+user.getAge());
		System.out.println("birth:"+user.getBirth());
		
		return "success";
	}
	
	
	
}
