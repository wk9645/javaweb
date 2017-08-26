package com.wk.mytag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		
		PageContext page = (PageContext)this.getJspContext();
		
		//控制是否输出标签体内容
		
		JspFragment fragment = this.getJspBody();
		
		fragment.invoke(null);
		
		//不输出标签后内容
//		throw new SkipPageException();
		
	}
}
