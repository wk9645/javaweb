package com.wk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wk.entity.Admin;
import com.wk.service.IAdminService;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	//封装数据
	private Admin admin = new Admin();
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	
	@Override
	public Admin getModel() {
		
		return admin;
	}
	
	//注入Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	public String login(){
		
		Admin adminInfo = adminService.login(admin);
		if(adminInfo == null){
			
			return "loginFailed";
			
		}else {
			
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}
}
