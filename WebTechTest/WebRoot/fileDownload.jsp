<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'fileDownload.jsp' starting page</title>
  </head>
  
  <body>
  		<table border="1" align="center">
  			<tr>
  				<th>序号</th>
  				<th>文件名</th>
  				<th>操作</th>
  				
  			</tr>
  			<c:forEach var="fn" items="${requestScope.fileNames}" varStatus="vs">
  				<tr>
  					<td>${vs.count }</td>
  					<td>${fn.value }</td>
  					
  					<td>
  						<%-- 构建一个地址 --%>
  						<c:url var="url" value="FileUpload">
  							<c:param name="method" value="down"></c:param>
  							<c:param name="fileName" value="${en.key}"></c:param>
  						</c:url>
  						<a href="${url }">下载</a>
  					</td>
  				</tr>
  			</c:forEach>
  		</table>
  
  </body>
</html>
