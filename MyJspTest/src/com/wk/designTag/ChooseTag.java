package com.wk.designTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	
	//设置临时变量用于存储要传递的值
	private boolean flag;
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		
		this.getJspBody().invoke(null);
		
	}
}
