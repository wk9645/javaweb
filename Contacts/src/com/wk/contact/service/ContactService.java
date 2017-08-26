package com.wk.contact.service;

import java.util.List;

import com.wk.contact.exception.NameRepeatException;
import com.wk.contact_web.entity.Contact;

public interface ContactService {
	public void addContact(Contact contact)throws NameRepeatException;//�����ϵ��
	public void updateContact(Contact contact);//�޸���ϵ��
	public void deleteContact(String id);//ɾ����ϵ��
	public List<Contact> findAll();  //��ѯ������ϵ��
	public Contact findById(String id);//���ݱ�Ų�ѯ��ϵ��
}
