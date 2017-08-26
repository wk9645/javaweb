<%@page import="com.wk.jsp.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.tag.wk.com" prefix="wk" %>

<html>
  <head>
    
    <title>My JSP 'DesignTag.jsp' starting page</title>
  </head>
  <body>
  	
  	<%-- 输出标签 --%>
 	<%-- <wk:ifout>hello</wk:ifout>  --%>
  	
  	<%-- 满足条件输出 --%>
  	<%-- <wk:if test="${7<5}">bye bye</wk:if> --%>
  	
  	<%-- 选择标签 --%>
  	<%-- <wk:choose>
  		<wk:if test="${10>3}">
  			条件成立
  		</wk:if>
  		<wk:else>
  			条件不成立
  		</wk:else>
  	</wk:choose>
  					--%>
  					
  	<%-- 遍历标签 --%>
  	<% 
  	 //保存数据
       //List
     	List<Student>  list = new ArrayList<Student>();
     	list.add(new Student("rose",18));
     	list.add(new Student("jack",28));
     	list.add(new Student("lucy",38));
     	//放入域中
     	pageContext.setAttribute("list",list);
     	
     	//Map
     	Map<String,Student> map = new HashMap<String,Student>();
     	map.put("100",new Student("mark",20));
     	map.put("101",new Student("maxwell",30));
     	map.put("102",new Student("narci",40));
     	//放入域中
     	pageContext.setAttribute("map",map);
     %>
     
     <wk:foreach items="${list}" var="student">
     		姓名：${student.name } - 年龄:${student.age }<br/>
     </wk:foreach>
     
     <hr/>
   
     <wk:foreach items="${map}" var="entry">
     	  编号：${entry.key} - 姓名：${entry.value.name} - 年龄：${entry.value.age }<br/>
     </wk:foreach>		
  					
  </body>
</html>
