<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body>
  	<form action="${APP_PATH}/user/login" method="post">
  		用户名：<input type="text" name="username" value=""/><br>
  		密码：<input type="password" name="password" value=""/><br>
  		<br>
  		<input type="submit" value="提交" />
  	</form>
  </body>
</html>
