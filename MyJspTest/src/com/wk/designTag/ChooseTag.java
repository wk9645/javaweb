package com.wk.designTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {
	
	//������ʱ�������ڴ洢Ҫ���ݵ�ֵ
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
