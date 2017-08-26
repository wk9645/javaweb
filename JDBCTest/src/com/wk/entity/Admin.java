package com.wk.entity;

public class Admin {

	private int id;
	private String userName;
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ",userName=" + userName + ", password=" + password + "]";
	}
	
	
}
