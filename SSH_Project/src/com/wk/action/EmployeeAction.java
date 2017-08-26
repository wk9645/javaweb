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
	 * 1��ע��service
	 */
	//ע��Employeeservice
	
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//ע��DeptService
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	/*
	 * 2�������Զ���װ����
	 */
	//��װ����id
	private int deptId; 
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}
	
	//��װԱ��
	private Employee employee = new Employee();     //ģ������
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	@Override
	public Employee getModel() {
		
		return employee;  //����ʵ������Ķ���
	}
	
	
	//�������request��map
	 
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
	
	
	/*
	 * 4����������
	 */
	
	/*
	 * 4.1 ��ʾ����Ա��
	 */
	public String list(){
		
		List<Employee> list = employeeService.getAll();
		request.put("listEmp", list);
		return "list";
	}
	
	
	/*
	 * 4.2 ����Ա��
	 */
	//��������ҳ��
	public String addView(){
		
		//��ȡ���в�����Ϣ
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	//���Ӳ���
	public String save(){
		//���ݲ���id��ȡ���ž���ֵ
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		employeeService.save(employee);
		return "listAction";
	}
	
	/*
	 * 4.3 ����Ա��
	 */

	//�������ҳ��
	
	public String updateView(){
		
		//��ȡҪ�޸�Ա��������id����תʱ��url����id�Զ���װ
		int id = employee.getId();    
		Employee employee = employeeService.findById(id);
		
		//���ҵ����еĲ���
		List<Dept> listDept = deptService.getAll();
//		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("listDept", listDept);
		
		//ͨ�����ݻ�����ʾĬ��ֵ
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.pop();
		vs.push(employee);  //�ѷ�װ�õ�Employee������ֵջ��ջ�����������ݻ���
		
		return "updateView";
	}
	
	//���²���
	public String update(){
		
		//��ȡ����id
		Dept dept = deptService.findById(deptId);
		employee.setDept(dept);
		
		//�޸�Ա��
		employeeService.update(employee);
		return "listAction";
		
	}
	
	/*
	 * 5��ɾ��Ա��
	 */
	
	public String delete(){
		//��ȡҪɾ��Ա��id
		int id = employee.getId();
		Employee employee = employeeService.findById(id);
		
		//ɾ��
		employeeService.delete(id);
		return "listAction";
	}

	
}