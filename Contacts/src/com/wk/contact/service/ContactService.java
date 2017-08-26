package com.wk.contact.service;

import java.util.List;

import com.wk.contact.exception.NameRepeatException;
import com.wk.contact_web.entity.Contact;

public interface ContactService {
	public void addContact(Contact contact)throws NameRepeatException;//添加联系人
	public void updateContact(Contact contact);//修改联系人
	public void deleteContact(String id);//删除联系人
	public List<Contact> findAll();  //查询所有联系人
	public Contact findById(String id);//根据编号查询联系人
}
