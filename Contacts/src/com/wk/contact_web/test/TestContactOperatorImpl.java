package com.wk.contact_web.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wk.contact_web.dao.ContactDao;
import com.wk.contact_web.dao.ContactDaoImpl;
import com.wk.contact_web.entity.Contact;

public class TestContactOperatorImpl {
ContactDao operator = null;
	
	/**
	 * ��ʼ������ʵ��
	 */
	@Before
	public void init(){
		operator = new ContactDaoImpl();
	}
	

	@Test
	public void testAddContact(){
		Contact contact = new Contact();
		//contact.setId("2");
		contact.setName("����2");
		contact.setGender("��");
		contact.setAge(20);
		contact.setPhone("134222233333");
		contact.setEmail("eric@qq.com");
		contact.setQq("33334444");
		operator.addContact(contact);
	}
	
	@Test
	public void testUpdateContact(){
		Contact contact = new Contact();
		contact.setId("1"); //�޸ĵ�ID
		contact.setName("����");
		contact.setGender("Ů");
		contact.setAge(30);
		contact.setPhone("135222233333");
		contact.setEmail("zhangsan@qq.com");
		contact.setQq("33334444");
		operator.updateContact(contact);
	}
	
	@Test
	public void testDeleteContact(){
		operator.deleteContact("2");
	}
	
	@Test
	public void testFindAll(){
		List<Contact> list = operator.findAll();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
	
	@Test
	public void testFindById(){
		Contact contact = operator.findById("1");
		System.out.println(contact);
	}
	
	@Test
	public void testCheckContact(){
		System.out.println(operator.checkContact("����1"));
	}
}
