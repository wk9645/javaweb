<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>

  </head>
  
  <body>
  
  <!-- get方式提交 -->
	<h3>get提交</h3>
  	<form method="get" action="${pageContext.request.contextPath }/LoginServlet">
  		姓名：<input type="text" name="name"/>
  		<input type="submit" value="登录"/>
  	</form>
	<hr/>
  	<!-- post方式提交 -->
	<h3>post提交</h3>
  	<form method="post" action="${pageContext.request.contextPath }/LoginServlet">
  		姓名：<input type="text" name="name"/>
  		<input type="submit" value="登录"/>
  	</form>
  
  </body>
</html>
