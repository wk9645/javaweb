package com.wk.hibernate1;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class App {
	
	
	@Test
	public void testHello(){
		
		/*
		 * 1��ʵ��������
		 */
		Employee emp = new Employee();
		emp.setEmpName("����");
		emp.setWorkDate(new Date());
		
		
		/*
		 * 2����ȡ���������ļ��Ĺ��������
		 */
		Configuration config = new Configuration();
		config.configure();   //�������ݿ������ļ�
		
		
		/*
		 * 3������session�Ĺ�����
		 */
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();                 //����session
		
		Transaction ts = session.beginTransaction();		//��������
		
		//����������ݿ�
		session.save(emp);
		
		//�ύ����
		ts.commit();
		//�ر�
		sf.close();
		session.close();
		
	}
	
}
