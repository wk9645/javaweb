<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<s:if test="#session.adminInfo != null">
	欢迎您：<s:property value="#session.adminInfo.adminName"/>&nbsp;&nbsp;
	<s:a href="">退出</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
	<s:a href="employee_addView">添加员工</s:a>
</s:if>
<s:else>
	<s:a href="login.jsp">登录</s:a>
	<s:a href="register.jsp">注册</s:a>
</s:else>