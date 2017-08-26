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
//		response.getWriter().write("���Գɹ�");

		if(test){
			this.getJspBody().invoke(null);
		}
		
		//��ȡ����ǩ,��testֵ���븸��ǩ��
		ChooseTag parent = (ChooseTag) this.getParent();
		parent.setFlag(test);
	}
	
}
