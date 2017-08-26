package com.wk.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wk.entity.Employee;
import com.wk.service.EmployeeService;

public class EmployeeAction extends ActionSupport {

	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@Override
	public String execute() throws Exception {
		
		Employee emp = employeeService.findById(1);
		
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		
		request.put("emp", emp);
		return SUCCESS;
	}
}
