package com.wk.struts2_json;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class ProvinceAction extends ActionSupport{
	

	//存储城市
	private List<String> citys;
	
	public List<String> getCitys() {
		return citys;
	}
	
	private Bean bean;
	
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	
	//json解析时会找get方法
	public Bean getBean() {
		return bean;
	}
	
	public String findCityByProv() {

		
		citys = new ArrayList<String>();
		if("陕西省".equals(bean.getProvince())){
			citys.add("西安");
			citys.add("咸阳");
			citys.add("渭南");
			citys.add("铜川");
		}else if("四川省".equals(bean.getProvince())){
			
			citys.add("成都");
			citys.add("九寨沟");
			citys.add("汶川");
		}else if("广东省".equals(bean.getProvince())){
			citys.add("广州");
			citys.add("深圳");
			citys.add("珠江");
		}
		return SUCCESS;
	}
}
