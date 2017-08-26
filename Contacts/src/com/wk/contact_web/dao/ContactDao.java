package com.wk.contact_web.dao;

import java.util.List;

import com.wk.contact_web.entity.Contact;

public interface ContactDao {
	public void addContact(Contact contact);//�����ϵ��
	public void updateContact(Contact contact);//�޸���ϵ��
	public void deleteContact(String id);//ɾ����ϵ��
	public List<Contact> findAll();  //��ѯ������ϵ��
	public Contact findById(String id);//���ݱ�Ų�ѯ��ϵ��
	public boolean checkContact(String name);//����������ѯ�Ƿ��ظ�
}

