<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  </head>
  <body>
  	<form action="${pageContext.request.contextPath }/user_register" method="post">
  		姓名：<input type="text" name="user.name"/><br/>
  		密码：<input type="password" name="user.pwd"/><br/>
  		年龄<input type="text" name="user.age"/><br/>
  		生日：<input type="text" name="user.birth"/><br/>
  		<input type="submit" value="提交"/>
  	</form>
  </body>
</html>
