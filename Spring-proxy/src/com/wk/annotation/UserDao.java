package com.wk.annotation;

import org.springframework.stereotype.Component;

@Component       //将UserDao加入容器
public class UserDao{

	public void save() {
		
		System.out.println("保存成功！");
	}
}
