package com.wk.static_proxy;

import org.junit.Test;


import com.wk.cglib_proxy.CglibProxy;
import com.wk.dynamic_proxy.DynamicProxy;

public class APP {

	
	//���Ծ�̬����
	public void testStaticProxy(){
		
		IUserDao userDao = new UserDao();
		UserDaoProxy proxy = new UserDaoProxy();
		proxy.setUserDao(userDao);
		
		proxy.save();
		
	}

	
	//���Զ�̬����
	@Test
	public void testDynamicProxy(){
		
		IUserDao dao = new UserDao();

		IUserDao proxy = (IUserDao) new DynamicProxy(dao).getInstance();
		
		
		proxy.save();
	}
	
	//����Cglib����
	@Test
	public void testCglibProxy(){
		
		IUserDao userDao = new UserDao();
		
		IUserDao proxy = (IUserDao)new CglibProxy(userDao).getInstance();
		
		proxy.save();
		
	}
	
}
