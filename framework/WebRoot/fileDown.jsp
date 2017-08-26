<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  
  	<%-- 显示文件下载列表 --%>
  
  	<table border="1" align="center">
		<tr>
			<td>编号</td>
			<td>文件名</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="fileName" items="${fileNames }" varStatus="vs">
			<tr>
				<td>${vs.count }</td>
				<td>${fileName }</td>
				<td>
					<c:url var="url" value="down_list">
						<c:param name="fileName" value="${fileName }"></c:param>
					</c:url>
					<a href="${url }">下载</a>
				</td>
			</tr>
		</c:forEach>
  	</table>
  
  </body>
</html>
