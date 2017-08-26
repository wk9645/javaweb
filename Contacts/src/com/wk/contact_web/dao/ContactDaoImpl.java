package com.wk.contact_web.dao;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.wk.contact_web.entity.Contact;
import com.wk.contact_web.util.XMLUtil;

public class ContactDaoImpl implements ContactDao{

	/**
	 * �����ϵ��
	 */
	public void addContact(Contact contact) {
		try {
			File file = new File("e:/contact.xml");
			Document doc = null;
			Element rootElem = null;
			if(!file.exists()){
				/**
				 * ���� ��contact���󱣴浽xml�ļ���
				 */
				//���û��xml�ļ����򴴽�xml�ļ�
				doc = DocumentHelper.createDocument();
				//��������ǩ
				rootElem = doc.addElement("contactList");
			}else{
				//�����xml�ļ������ȡxml�ļ�
				doc = XMLUtil.getDocument();
				//�����xml�ļ�����ȡ����ǩ
				rootElem = doc.getRootElement();
			}

			//���contact��ǩ
			/**
			 * <contact id="1">
					<name>eric</name>
					<gender>��</gender>
					<age>20</age>
					<phone>1343333</phone>
					<email>eric@qq.com</email>
					<qq>554444</qq>
				</contact>
			 */
			Element contactElem = rootElem.addElement("contact");
			
			/**
			 * ��ϵͳ�Զ����������Ψһ��IDֵ����ֵ����ϵ��
			 */
			String uuid = UUID.randomUUID().toString().replace("-","");
			
			contactElem.addAttribute("id", uuid);
			contactElem.addElement("name").setText(contact.getName());
			contactElem.addElement("gender").setText(contact.getGender());
			contactElem.addElement("age").setText(contact.getAge()+"");
			contactElem.addElement("phone").setText(contact.getPhone());
			contactElem.addElement("email").setText(contact.getEmail());
			contactElem.addElement("qq").setText(contact.getQq());
			
			//��Documentд����xml�ļ�
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * ɾ����ϵ��
	 */
	public void deleteContact(String id) {
		try {
			//1.��ȡxml�ļ�
			Document doc = XMLUtil.getDocument();
			//2.��ѯ��Ҫɾ��id��contact
			Element contactElem = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
			//ɾ����ǩ
			if(contactElem!=null){
				contactElem.detach();
			}
			
			//3.��Documentд����xml�ļ�
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��ѯ������ϵ��
	 */
	public List<Contact> findAll() {
		//1.��ȡxml�ļ�
		Document doc = XMLUtil.getDocument();
		
		//2.����List����
		List<Contact> list = new ArrayList<Contact>();
		//3.��ȡcontact��ǩ
		List<Element> conList = (List<Element>)doc.selectNodes("//contact");
		for(Element e:conList){
			//����COntact����
			Contact c = new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
			//��Contact����list��
			list.add(c);
		}
		return list;
	}

	/**
	 * ���ݱ�Ų�ѯ��ϵ��
	 */
	public Contact findById(String id) {
		Document doc = XMLUtil.getDocument();
		Element e = (Element)doc.selectSingleNode("//contact[@id='"+id+"']");
		
		Contact c = null;
		if(e!=null){
			//����COntact����
			c = new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setPhone(e.elementText("phone"));
			c.setEmail(e.elementText("email"));
			c.setQq(e.elementText("qq"));
		}
		return c;
	}

	/**
	 * �޸���ϵ��
	 */
	public void updateContact(Contact contact) {
		/**
		 * ���� �޸�idֵΪ2����ϵ��
		 * 	1����ѯidֵΪ2��contact��ǩ
		 *  2���޸�contact��ǩ������
		 */
		try {
			//1.��ȡxml�ļ�
			Document doc = XMLUtil.getDocument();
			
			Element contactElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			
			//2.�޸�contact��ǩ����
			contactElem.element("name").setText(contact.getName());
			contactElem.element("gender").setText(contact.getGender());
			contactElem.element("age").setText(contact.getAge()+"");
			contactElem.element("phone").setText(contact.getPhone());
			contactElem.element("email").setText(contact.getEmail());
			contactElem.element("qq").setText(contact.getQq());
			
			//3.��Documentд����xml�ļ�
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		//����UUID
		String uuid = UUID.randomUUID().toString().replace("-","");
		System.out.println(uuid);
	}

	/**
	 * true���ظ�
	 * false�����ظ�
	 */
	public boolean checkContact(String name) {
		//��ѯname��ǩ�����ݺʹ����nameֵ�Ƿ�һ�£�
		Document doc = XMLUtil.getDocument();
		Element nameElem = (Element)doc.selectSingleNode("//name[text()='"+name+"']");
		if(nameElem!=null){
			return true;
		}else{
			return false;
		}
	}


}
