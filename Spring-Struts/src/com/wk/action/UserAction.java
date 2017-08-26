package com.wk.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wk.service.UserService;

public class UserAction extends ActionSupport{
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public String execute() throws Exception {
		
		userService.save();
		return SUCCESS;
	}
}
