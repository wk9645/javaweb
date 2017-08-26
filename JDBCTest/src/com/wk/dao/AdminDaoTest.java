package com.wk.dao;

import java.util.List;

import org.junit.Test;

import com.wk.entity.Admin;

public class AdminDaoTest {
	
	@Test
	public void test(){
		
		AdminDao ad = new AdminDao();
		//删除第一个数据
//		ad.delete(1);
		//增加一条记录
//		ad.insert(new Admin("亚索","789"));
		//查找所有
//		List<Admin> admins = ad.findAll();
//		System.out.println(admins);
		//根据id查找
		Admin admin = ad.findById(10);
		System.out.println(admin);
	}
	
}
