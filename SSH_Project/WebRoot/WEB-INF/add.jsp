<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
	</head>
  <body>
  		<%-- 在此页面添加员工信息，通过表单提交到save方法中进行保存 --%>
  		<%--theme="simple"指定struts标签不换行 --%>
  		<s:form action="/employee_save.action" method="post" theme="simple">
  		<table border="1" align="center" cellpadding="5" cellspacing="0">
  			<tr>
  				<td>员工姓名</td>
  				<td>
  					<s:textfield name="empName" id="empName" value=""></s:textfield>
  				</td>
  			</tr>
  			<tr>
  				<td>员工薪水</td>
  				<td>
  					<s:textfield name="salary" id="salary" value=""></s:textfield>
  				</td>
  			</tr>
  			<tr>
  				<td>选择部门</td>
  				<td>
	  				<s:select name="deptId" list="#request.listDept" headerKey="-1" headerValue="请选择" listKey="id" listValue="name" value="-1">
	  				</s:select>
	  			</td>
  			</tr> 
  			<tr>
  				<td colspan="2">
  					<s:submit value="添加员工"></s:submit>
  				</td>
  			</tr>
  		</table>
  	</s:form>
  </body>
</html>
