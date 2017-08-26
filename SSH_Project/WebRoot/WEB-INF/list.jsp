<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>员工列表展示</title>
	</head>
	
	<%-- 添加员工,跳转到添加页面 --%>
	<div align="center" style="width: 80%;">
		<jsp:include page="/head.jsp"></jsp:include>
	</div>
  <body>
  
  		<table border="1" align="center" width="500px">
  			<tr>
  				<td>序号</td>
  				<td>员工编号</td>
  				<td>员工名称</td>
  				<td>员工薪水</td>
  				<td>操作</td>
  			</tr>
  			<s:if test="#request.listEmp != null">
  				<s:iterator var="emp" value="#request.listEmp" status="st">
  					<tr>
  						<td><s:property value="#st.count"/></td>
  						<td><s:property value="#emp.id"/></td>
  						<td><s:property value="#emp.empName"/></td>
  						<td><s:property value="#emp.salary"/></td>
  						<td>
  							<s:a href="employee_updateView.action?id=%{#emp.id}">更新</s:a>
  							<s:a href="employee_delete.action?id=%{#emp.id}">删除</s:a>
						</td>
  					</tr>
  				</s:iterator>
  			</s:if>
  			<s:else>
  				<tr>
  					<td colspan="5">对不起，没有你要找的数据</td>
  				</tr>
  			</s:else>
  		</table>
  
  </body>
</html>
