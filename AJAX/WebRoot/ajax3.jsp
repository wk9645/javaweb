<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'ajax1.jsp' starting page</title>
  </head>
  
  <body>
  	<input id="textId" name="userName" type="text"><span id="picture"></span>

  	
  	<!--三、检测用户名师是否重复 -->
  	
  	
  	<%--使用js脚本 --%>
  	<script type="text/javascript">
  		
  		//判断是否有AJAX对象
  		function createAJAX(){
  			
  			var ajax = null;
  			//如果是IE浏览器
			try{
			
	  			ajax = new ActiveXObject("microsoft.xmlhttp");
			}catch(e){
			
	  			try{
  			
					ajax = new XMLHttpRequest();		
  				}catch(e2){
  				
  					alert("浏览器不支持AJAX");
  				}
  				
			}
  			return ajax;
  		}
  	
  	</script>
  	
  	<script type="text/javascript">
  	
  		document.getElementById("textId").onmouseout = function(){
  		
			//1、创建
  			var ajax = createAJAX();
  			//2、准备发送请求
  			var method = "GET";
  			var userName = this.value;
  			var url = "${pageContext.request.contextPath}/AJAX3?date=?" + new Date().getTime() + "&userName=" + userName;
  			ajax.open(method,url);
  			//3、发送请求体中的数据到服务器，如果没有数据则传入null
  			ajax.send(null);
  			//4、获取状态码,如果等于4发送请求
  			ajax.onreadystatechange = function(){
  			
	  			if(ajax.readyState == 4){
	  				
	  				//如果响应码为200
	  				if(ajax.status == 200){
	  				
	  					//使用ajax对象获取服务器响应的html数据
	  					var pictureType = ajax.responseText;
	  					
	  					var spanElem = document.getElementById("picture");
	  					spanElem.innerHTML = pictureType;	 
	  				}
	  			}
  			}  			
  		}
  	</script>
  	
  </body>
</html>
