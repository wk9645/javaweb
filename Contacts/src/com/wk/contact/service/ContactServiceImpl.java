package com.wk.contact.service;

import java.util.List;

import com.wk.contact.exception.NameRepeatException;
import com.wk.contact_web.dao.ContactDao;
import com.wk.contact_web.dao.ContactDaoImpl;
import com.wk.contact_web.entity.Contact;

public class ContactServiceImpl implements ContactService {
	ContactDao dao = new ContactDaoImpl();
	
	public void addContact(Contact contact) throws NameRepeatException {
		//执行业务逻辑判断
		if(dao.checkContact(contact.getName())){
			//重复
			/**
			 * 注意： 如果业务层方法出现任何业务异常，则返回标记（自定义异常）到servlet
			 */
			throw new NameRepeatException("姓名重复，不可使用");
		}
		//如果不重复，才执行添加方法
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
