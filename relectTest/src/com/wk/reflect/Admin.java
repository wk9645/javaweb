package com.wk.reflect;

public class Admin {

	private int id = 1;
	private String name = "ÕÅÈý·á";
	private String password = "123";
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(String name){
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + "]";
	}
	
}
