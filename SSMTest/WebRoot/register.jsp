<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
 
 	<form action="${pageContext.request.contextPath }/student/register.action" method="post">
  			<table border="2" align="center">
  				<tr>
  					<td>
  						编号:<input type="text" name="id">
  					</td>
  				</tr>
  				<tr>
  					<td>
  						姓名:<input type="text" name="name">
  					</td>
  				</tr>
  				
  				<tr>
  					<td>
  						薪水:<input type="text" name="sal"/>
  					</td>
  				</tr>
  				<tr>
  					<td colspan="2"><input type="submit" value="注册"></td>
  				</tr>
  			</table>
  		</form>
 	
 
  </body>
</html>
