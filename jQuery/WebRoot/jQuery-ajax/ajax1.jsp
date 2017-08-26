<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>获取时间</title>
	
  	<script type="text/javascript" src="../js/jquery-1.8.2.js"></script></head>
  
  <body>
  		
  		当前时间为：<span id="spanId"></span><br/>
  		<input type="button" value="获取时间"/>
  		
  		<script type="text/javascript">
  		
			$(":button").click(function(){
			
	  			var url = "${pageContext.request.contextPath}/JqueryGetTime?time=" + new Date().getTime();
	  			$("#spanId").load(url,);
			});		
  		
  		</script>
  
  
  </body>
</html>
