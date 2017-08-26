<%@ page language="java" 
	import="java.util.*,com.wk.jsp.*"
 	pageEncoding="utf-8"%>


<html>
  <head>
    <title>使用EL表达式</title>
  </head>
  
  <body>
  		
  		<%
  			List<Student> stus = new ArrayList<Student>();
  			stus.add(new Student("zhangsan",18));
  			stus.add(new Student("lisi",20));
			pageContext.setAttribute("stus", stus);
			  			
  		 %>
  		
  		<%-- 使用EL表达式取域中的数据 --%>
  		
  		EL:${stus[0].name} - ${stus[0].age}
  </body>
</html>
