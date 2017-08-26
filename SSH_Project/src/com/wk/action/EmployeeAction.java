package com.wk.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.wk.entity.Dept;
import com.wk.entity.Employee;
import com.wk.service.IDeptService;
import com.wk.service.IEmployeeService;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>,RequestAware{

	/*
	 * 1、注入service
	 */
	//注入Employeeservice
	
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//注入DeptService
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	/*
	 * 2、请求自动封装数据
	 */
	//封装部门id
	private int deptId; 
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}
	
	//封装员工
	private Employee employee = new Employee();     //模型驱动
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	@Override
	public Employee getModel() {
		
		return employee;  //返回实例化后的对象
	}
	
	
	//保存代表request的map
	 
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
	
	
	/*
	 * 4、基本功能
	 */
	
	/*
	 * 4.1 显示所有员工
	 */
	public String list(){
		
		List<Employee> list = employeeService.getAll();
		request.put("listEmp", list);
		return "list";
	}
	
	
	/*
	 * 4.2 添加员工
	 */
	//进入添加页面
	public String addView(){
		
		//获取所有部门信息
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	//添加操作
	public String save(){
		//根据部门id获取部门具体值
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.save(employee);
		return "listAction";
	}
	
	/*
	 * 4.3 更新员工
	 */

	//进入更新页面
	
	public String updateView(){
		
		//获取要修改员工的主键id，跳转时的url参数id自动封装
		int id = employee.getId();    
		Employee employee = employeeService.findById(id);
		
		//查找到所有的部门
		List<Dept> listDept = deptService.getAll();
//		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("listDept", listDept);
		
		//通过数据回显显示默认值
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(employee);  //把封装好的Employee对象方在值栈的栈顶，用于数据回显
		
		return "updateView";
	}
	
	//更新操作
	public String update(){
		
		//获取部门id
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		
		//修改员工
		employeeService.update(employee);
		return "listAction";
		
	}
	
	/*
	 * 5、删除员工
	 */
	
	public String delete(){
		//获取要删除员工id
		int id = employee.getId();
		Employee employee = employeeService.findById(id);
		
		//删除
		employeeService.delete(id);
		return "listAction";
	}

	
}
