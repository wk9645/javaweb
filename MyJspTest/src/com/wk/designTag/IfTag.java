package com.wk.designTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class IfTag extends SimpleTagSupport{

	private boolean test;
	
	public void setTest(boolean test) {
		this.test = test;
	}
	@Override
	public void doTag() throws JspException, IOException {
		
//		PageContext page = (PageContext) this.getJspContext();
//		HttpServletResponse response = (HttpServletResponse) page.getResponse();
//		response.getWriter().write("测试成功");

		if(test){
			this.getJspBody().invoke(null);
		}
		
		//获取父标签,将test值传入父标签中
		ChooseTag parent = (ChooseTag) this.getParent();
		parent.setFlag(test);
	}
	
}
