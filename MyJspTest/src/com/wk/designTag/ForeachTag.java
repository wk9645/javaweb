package com.wk.designTag;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForeachTag extends SimpleTagSupport {
	private Object items;
	private String var;
	public void setItems(Object items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		//��ÿһ��Student�������page���У���jspҳ����ʾʱʹ��
		/*PageContext page = (PageContext) this.getJspContext();
		if(items instanceof List){
			List<Student> list = (List)items;
			for (Object obj : list) {
				page.setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		}if(items instanceof Map){
			Map<String, Student> map = (Map)items;
			
			Set<Entry<String,Student>> entrySet = map.entrySet();
			for( Entry<String, Student> entry: entrySet){
				System.out.println(entry.getKey());
				page.setAttribute(var, entry);
				this.getJspBody().invoke(null);
			}
		}*/
		
		//����items����
				//List
				PageContext pageContext = (PageContext)this.getJspContext();
				if(items instanceof List){
					List list = (List)items;
					for (Object obj: list) {
						//��ÿ����������������(pageContext)
						pageContext.setAttribute(var, obj);
						//��ʾ��ǩ������
						this.getJspBody().invoke(null);
					}
				}
				
				//Map
				if(items instanceof Map){
					Map map = (Map)items;
					Set<Entry> entrySet = map.entrySet();
					for(Entry entry :entrySet){
						//��ÿ����������������(pageContext)
						pageContext.setAttribute(var, entry);
						System.out.println(entry.getKey());
						//��ʾ��ǩ������
						this.getJspBody().invoke(null);
					}
				}
				
	}
}
