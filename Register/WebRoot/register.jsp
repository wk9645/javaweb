<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<form method="post" action="${pageContext.request.contextPath}/AdminServlet?method=register">
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text" name="userName"/>
					${requestScope.msg}				
				</td>
			</tr>	
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"/></td>
			</tr>				
			<tr>
				<td colspan="2"><input type="submit" value="注册"/></td>
			</tr>
		</table>
	</form>  
  </body>
</html>
