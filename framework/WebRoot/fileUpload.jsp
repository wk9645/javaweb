<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
  		<form action="${pageContext.request.contextPath }/fileUploadAction.action" method="post" enctype="multipart/form-data">
  		用户名：<input type="text" name="name"/><br/>
  		选择文件:<input type="file" name="file1"/><br/>
  		<input type="submit" value="上传"/>
  	</form>
  	
  </body>
</html>
