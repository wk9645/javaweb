package com.wk.contact.service;

import java.util.List;

import com.wk.contact.exception.NameRepeatException;
import com.wk.contact_web.dao.ContactDao;
import com.wk.contact_web.dao.ContactDaoImpl;
import com.wk.contact_web.entity.Contact;

public class ContactServiceImpl implements ContactService {
	ContactDao dao = new ContactDaoImpl();
	
	public void addContact(Contact contact) throws NameRepeatException {
		//ִ��ҵ���߼��ж�
		if(dao.checkContact(contact.getName())){
			//�ظ�
			/**
			 * ע�⣺ ���ҵ��㷽�������κ�ҵ���쳣���򷵻ر�ǣ��Զ����쳣����servlet
			 */
			throw new NameRepeatException("�����ظ�������ʹ��");
		}
		//������ظ�����ִ����ӷ���
		dao.addContact(contact);
	}

	public void deleteContact(String id) {
		dao.deleteContact(id);
	}

	public List<Contact> findAll() {
		return dao.findAll();
	}

	public Contact findById(String id) {
		return dao.findById(id);
	}

	public void updateContact(Contact contact) {
		dao.updateContact(contact);
	}

}
