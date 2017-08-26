<%@ page language="java" 
	import="java.util.*" 
	pageEncoding="utf-8"
	%>

<html>
  <head>
    <title>9大内置对象</title>
  </head>
  
  <body>
  		
  		<!-- PageContext域对象 -->
  		<%
  			pageContext.setAttribute("message","from request",PageContext.REQUEST_SCOPE);
  			
  			//pageContext.setAttribute("message","from pageContext");
  			//String message = (String)pageContext.getAttribute("message");
  			//out.write(message);
  		 %>	
  		 
  		 <%=request.getAttribute("message") %>
  
  </body>
</html>
