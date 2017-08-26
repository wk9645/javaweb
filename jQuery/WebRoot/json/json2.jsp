<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>省份-城市-区域三级联动</title>
	<script type="text/javascript" src="js/ajax.js"></script>
  </head>
  
  <body>
  		
  		<select id="provId" name="provinceName">
  			<option>请选择省份</option>
  			<option>陕西省</option>
  			<option>四川省</option>
  			<option>广东省</option>
  		</select>
  		
  		<select id="cityId" name="cityName">
  			<option>请选择城市</option>
  		</select>

  		<select id="regionId" name="regionName">
  			<option>请选择区域</option>
  		</select>
  		
  		<script type="text/javascript">
  		
  		
  		//获取城市下拉框改变事件
  		document.getElementById("provId").onchange = function(){
  		
  			//刷新下拉框内容
  			var cityElem = document.getElementById("cityId");
  			cityElem.options.length = 1;
  			
  			//获取省份下拉框选项，然后发送到服务器
  			var province = this[this.selectedIndex].innerHTML;
  			
  			if("请选择省份" != province){
  				
	 			//1、创建Ajax对象
	 			var ajax = createAJAX();
	 			
	 			//2、准备发送
	 			var method = "POST";
	 			var url = "${pageContext.request.contextPath}/findCityByProv?time=" + new Date().getTime();
	 			ajax.open(method,url);
	 			//3、设置请求头
	 			ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
  				//4、发送
 				//添加到请求体
  				var content = "bean.province=" + province;
  				ajax.send(content);
  				
  				
  				//5、监听状态
  				ajax.onreadystatechange = function(){
  				
  					if(ajax.readyState == 4){
  					
  						if(ajax.status == 200){
  						
  							//6、获取ajax数据
  							var ajaxJava = ajax.responseText;
							//将java格式的json数据转换为js格式的json文本
							var ajaxJs = eval("(" + ajaxJava + ")");
	  						var area = ajaxJs.citys;
							for(var i =0; i<ajaxJs.citys.length; i++){
								
	  							var optionElem = document.createElement("option");
	  							//将数组中的城市放在option中
	  							optionElem.innerHTML = area[i];
	  							//将option添加到city下拉框标签中
	  							cityElem.appendChild(optionElem); 
							}
  						}
  					}
  				}
  			}
  		
  		
  		}
  			
  		</script>

  </body>
</html>
