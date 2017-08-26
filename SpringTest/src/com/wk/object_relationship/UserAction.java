package com.wk.object_relationship;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;



//@Component
@Controller
public class UserAction {
	
	@Resource
	private UserService userService;
	public void execute(){
		
		userService.save();
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
