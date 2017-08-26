<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>json1</title>
  </head>
  
  <body>
  	
  	<script type="text/javascript">
  	
  	/*	1、创建一个对象
  	 	var p = {id:4,name:'wk',gender:'男'};	
  		document.write(p.id);
  		document.write(p.name);
  		document.write(p.gender);
  	 */
  	 
  	 /* 2、创建一个数组
  	 	var p = [{name:"wk1",age:15},{name:"wk1",age:15},{name:"wk1",age:15}];
  	 	for(var i=0; i<p.length; i++){
	  		document.writeln("姓名：" + p[i].name + "年龄：" + p[i].age);
  	 	} 
  	 */
  	 
  	 /* 3、json中创建函数 
  	 	var p = {
 	 		 name:"wk",
  	 		 age:21,
  	 		 info:function(str){
  	 			alert(str);
  	 		 }
	  	};
	  	p.info("hello"); 
	 */
  	</script>	
  
  
  </body>
</html>
