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
		//将每一个Student对象放在page域中，在jsp页面显示时使用
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
		
		//遍历items数据
				//List
				PageContext pageContext = (PageContext)this.getJspContext();
				if(items instanceof List){
					List list = (List)items;
					for (Object obj: list) {
						//把每个对象放入域对象中(pageContext)
						pageContext.setAttribute(var, obj);
						//显示标签体内容
						this.getJspBody().invoke(null);
					}
				}
				
				//Map
				if(items instanceof Map){
					Map map = (Map)items;
					Set<Entry> entrySet = map.entrySet();
					for(Entry entry :entrySet){
						//把每个对象放入域对象中(pageContext)
						pageContext.setAttribute(var, entry);
						System.out.println(entry.getKey());
						//显示标签体内容
						this.getJspBody().invoke(null);
					}
				}
				
	}
}
