package com.wk.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wk.entity.Admin;
import com.wk.service.AdminService;

public class AdminAction extends ActionSupport{

	
	private Admin admin;
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	//��ȡservice
	private AdminService as = new AdminService();
	
	
	public String login() throws Exception {
		
		System.out.println(admin.getUserName());
		System.out.println(admin.getPwd());
		Admin adminInfo = as.getAdmin(admin);
		
		//��½ʧ��
		if(adminInfo == null)
			return "input";

		//��½�ɹ��������ݱ�����session��
		ActionContext.getContext().getSession().put("AdminInfo",adminInfo);
		return "loginSuccess";
	}
	
	
	/*
	 * ��ʾ�б�
	 */
	
	public String list(){
		
		try {
			List<Admin> admins = as.getAll();
			
			ActionContext.getContext().getSession().put("list", admins);
			return "list";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	
}
