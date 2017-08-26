<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'fileUpload.jsp' starting page</title>

  </head>
  
  <body>
  		
  		<form method="post" action="${pageContext.request.contextPath }/FileUpload?method=upload" enctype="multipart/form-data">
  			用户名：<input type="text" name="userName"/><br/>
  			选择文件:<input type="file" name="file"/><br/> 
  					<input type="submit" value="提交"/>	
  		</form>
  
  </body>
</html>
