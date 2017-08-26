package com.wk.interceptor;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{
	
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("÷¥––¡Àexecute()");
		return "success";
	}

}
