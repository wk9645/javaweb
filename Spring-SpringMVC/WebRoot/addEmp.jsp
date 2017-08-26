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
  </head>
  
  <body>
  		<form action="${pageContext.request.contextPath }/add.action" method="post">
  			<table border="2" align="center">
  				<tr>
  					<td>
  						姓名:<input type="text" name="userName">
  					</td>
  				</tr>
  				<tr>
  					<td>
  						<input type="radio" name="gender" value="男">男
  						<input type="radio" name="gender" value="女">女
  					</td>
  				</tr>
  				<tr>
  					<td>
  						入职日期:<input type="text" name="workDate">
  					</td>
  				</tr>
  				<tr>
  					<td colspan="2"><input type="submit" value="提交"></td>
  				</tr>
  			</table>
  		</form>
  </body>
</html>
