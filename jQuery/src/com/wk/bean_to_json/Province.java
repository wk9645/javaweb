package com.wk.bean_to_json;

import java.util.ArrayList;

public class Province {

	private int proId;
	private String proName;
	private ArrayList<City> aList = new ArrayList<City>();
	
	public Province(int proId, String proName, ArrayList<City> aList) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.aList = aList;
	}
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public ArrayList<City> getaList() {
		return aList;
	}
	public void setaList(ArrayList<City> aList) {
		this.aList = aList;
	}
	
}
