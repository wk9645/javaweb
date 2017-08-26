package com.wk.object_relationship;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("com/wk/object_relationship/bean.xml");
	@Test
	public void test() throws Exception {
		
		UserAction action = (UserAction) ac.getBean("userAction3");
		
		action.execute();
	}
	
}
