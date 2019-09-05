<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Lesson One</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  	<form action="${APP_PATH}/hello" method="post">
  		用户名：<input type="text" name="username" value="nana"/><br>
  		密码：<input type="password" name="password" value="123456"/><br>
  		状态：<input type="radio" name="status" value="1" checked/>可用 <input type="radio" name="status" value="0"/>禁用
  		<br>
  		<input type="submit" value="提交" />
  	</form>
  </body>
</html>
