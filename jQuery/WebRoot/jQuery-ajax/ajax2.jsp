<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户注册</title>
	
  	<script type="text/javascript" src="../js/jquery-1.8.2.js"></script></head>
  
  <body>
  		
  			<table border="2" align="center">
  				<tr>
  					<td>用户名</td>
  					<td><input type="text" name="userName"/></td>
  				</tr>
  				<tr>
  					<td>密码</td>
  					<td><input type="password" name="password"/></td>
  				</tr>
  				<tr>
  					<td colspan="2" align="center" style="backgound-color:#7CFC00">
  						<input type="button" value="注册"/>
  					</td>
  				</tr>
  			</table>
  		
  		<span id="spanId"></span>
  		
  		<script type="text/javascript">
  		
  		
  			//发送位置
  			$(":button").click(function(){
  			
	  			var url = "${pageContext.request.contextPath}/Register?time=" + new Date().getTime();
				var userName = $(":text").val();
				var password = $(":password").val();
	  			//请求数据
	  			var sendData = {
	  				"userName" : userName,
	  				"password" : password
	  			};
	  			//使用post方式发送
	  			//回调函数第一个参数为服务端返回信息
	  			$.post(url,sendData,function(backData){
	  			
	  				//创建img标签
		  			var $img = $("<img src='"+backData+"'width='50px' height='50px'/>");
		  			//添加到span中
		  			
		  			$("#spanId").text("");
		  			$("#spanId").append($img);
	  			
	  			});
  			});
  			
  		</script>
  
  
  </body>
</html>
