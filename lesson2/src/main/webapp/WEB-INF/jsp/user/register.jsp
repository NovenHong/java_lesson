<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body>
  	<form action="${APP_PATH}/user/register" method="post">
  		用户名：<input type="text" name="username" value=""/><br>
  		密码：<input type="password" name="password" value=""/><br>
  		状态：<input type="radio" name="status" value="1" checked/>可用 <input type="radio" name="status" value="0"/>禁用
  		<br>
  		地址1：<br>
  		国家：<input type="text" name="addressList[0].country" value=""/><br>
  		省份：<input type="text" name="addressList[0].province" value=""/><br>
  		城市：<input type="text" name="addressList[0].city" value=""/><br>
  		街道：<input type="text" name="addressList[0].street" value=""/><br>
  		<br>
  		地址2：<br>
  		国家：<input type="text" name="addressList[1].country" value=""/><br>
  		省份：<input type="text" name="addressList[1].province" value=""/><br>
  		城市：<input type="text" name="addressList[1].city" value=""/><br>
  		街道：<input type="text" name="addressList[1].street" value=""/><br>
  		<input type="submit" value="提交" />
  	</form>
  </body>
</html>
