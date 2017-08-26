package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wk.entity.Dept;
import com.wk.service.DeptService;

public class APP {

	private ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
	
	
	@Test
	public void testAPP() throws Exception {
	
		
		DeptService deptService = (DeptService) ac.getBean("deptService");
		
		System.out.println(deptService);
		deptService.save(new Dept());
		
	}
	
	
}
