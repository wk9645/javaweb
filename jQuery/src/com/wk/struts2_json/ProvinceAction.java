package com.wk.struts2_json;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;


public class ProvinceAction extends ActionSupport{
	

	//�洢����
	private List<String> citys;
	
	public List<String> getCitys() {
		return citys;
	}
	
	private Bean bean;
	
	public void setBean(Bean bean) {
		this.bean = bean;
	}
	
	//json����ʱ����get����
	public Bean getBean() {
		return bean;
	}
	
	public String findCityByProv() {

		
		citys = new ArrayList<String>();
		if("����ʡ".equals(bean.getProvince())){
			citys.add("����");
			citys.add("����");
			citys.add("μ��");
			citys.add("ͭ��");
		}else if("�Ĵ�ʡ".equals(bean.getProvince())){
			
			citys.add("�ɶ�");
			citys.add("��կ��");
			citys.add("�봨");
		}else if("�㶫ʡ".equals(bean.getProvince())){
			citys.add("����");
			citys.add("����");
			citys.add("�齭");
		}
		return SUCCESS;
	}
}
