package com.wk.designTag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ElseTag extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		
		//ªÒ»°∏∏±Í«©
		ChooseTag parent = (ChooseTag) this.getParent();
		boolean test = parent.isFlag();
		
		if(!test){
			this.getJspBody().invoke(null);
		}
	}
}
