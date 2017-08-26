package com.wk.static_proxy;

import org.junit.Test;


import com.wk.cglib_proxy.CglibProxy;
import com.wk.dynamic_proxy.DynamicProxy;

public class APP {

	
	//测试静态代理
	public void testStaticProxy(){
		
		IUserDao userDao = new UserDao();
		UserDaoProxy proxy = new UserDaoProxy();
		proxy.setUserDao(userDao);
		
		proxy.save();
		
	}

	
	//测试动态代理
	@Test
	public void testDynamicProxy(){
		
		IUserDao dao = new UserDao();

		IUserDao proxy = (IUserDao) new DynamicProxy(dao).getInstance();
		
		
		proxy.save();
	}
	
	//测试Cglib代理
	@Test
	public void testCglibProxy(){
		
		IUserDao userDao = new UserDao();
		
		IUserDao proxy = (IUserDao)new CglibProxy(userDao).getInstance();
		
		proxy.save();
		
	}
	
}
