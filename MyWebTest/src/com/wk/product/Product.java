package com.wk.product;

public class Product {

	private String id;
	private String proName;
	private String proType;
	private double proPrice;
	

	public Product() {
		super();
	}
	
	public Product(String id, String proName, String proType, double proPrice) {
		super();
		this.id = id;
		this.proName = proName;
		this.proType = proType;
		this.proPrice = proPrice;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", proName=" + proName + ", proType="
				+ proType + ", proPrice=" + proPrice + "]";
	}
	
	
}
