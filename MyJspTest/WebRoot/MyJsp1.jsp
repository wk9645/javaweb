<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>My JSP 'MyJsp1.jsp' starting page</title>
  </head>
  <body>
  	<!-- jsp表达式 -->
    <%
    	String name = "zhangsan";
     %>
    
    <%=name %>
    
    <!-- jsp脚本 -->
    <%
    	//System.out.println("这是脚本区");
     %>
     
     <%
     	for(int i=1;i<=6;i++){
      %>
		<h<%=i %>>标题<%=i %></h<%=i %>> 
		<br/>     
      <%
      	}
       %>
       <!-- jsp声明 -->
       <%!
       		int age = 65;
       		public int getAge(){
	       		return age;
	       	}
       		
        %>
        <%=getAge() %>
       
    <%--9*9乘法表 --%>
    <hr/>
    <%
    	for(int i=1;i<=9;i++){
    		for(int j=1;j<=i;j++){
     %>
     	<%=i %>*<%=j %>=<%=(i*j) %>
     <%
     	}
      %>
      <br/>
     <%
     	}
      %>
      
      <hr/>
      
      <!-- include 指令 -->
      	这是MyJsp1页面
      <%@include file="MyJsp_include.jsp" %>
    
  </body>
</html>
