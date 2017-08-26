<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%-- 导入标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
    <title>My JSP 'MyJspTag.jsp' starting page</title>
  </head>
  
  <body>
  	
  	<jsp:include page="/MyJsp_include.jsp">
  		<jsp:param value="nihao" name="msg"/>
  	</jsp:include>
  	
  			
  </body>
</html>
