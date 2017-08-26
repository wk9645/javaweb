<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  		<a href="${pageContext.request.contextPath }/fileUpload.jsp">文件上传</a> &nbsp;&nbsp;&nbsp;
  		<a href="${pageContext.request.contextPath }/FileUpload?method=downList">文件下载</a> 
  </body>
</html>
