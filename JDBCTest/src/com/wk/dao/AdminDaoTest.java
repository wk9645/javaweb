package com.wk.dao;

import java.util.List;

import org.junit.Test;

import com.wk.entity.Admin;

public class AdminDaoTest {
	
	@Test
	public void test(){
		
		AdminDao ad = new AdminDao();
		//ɾ����һ������
//		ad.delete(1);
		//����һ����¼
//		ad.insert(new Admin("����","789"));
		//��������
//		List<Admin> admins = ad.findAll();
//		System.out.println(admins);
		//����id����
		Admin admin = ad.findById(10);
		System.out.println(admin);
	}
	
}
