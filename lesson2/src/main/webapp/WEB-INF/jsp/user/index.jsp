<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户中心</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  </head>
  
  <body>
  	用户中心
  	
  	<table>
  		<thead>
  			<tr>
  				<th align="center">ID</th>
  				<th align="center">账号</th>
  				<th align="center">密码</th>
  				<th align="center">创建时间</th>
  			</tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${data }" var="item" varStatus="status">
  				<tr>
  					<td>${item.id }</td>
  					<td>${item.username }</td>
  					<td>${item.password }</td>
  					<td>
  						<jsp:useBean id="dateValue" class="java.util.Date"/>
						<jsp:setProperty name="dateValue" property="time" value="${item.createTime*1000}"/>
						<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/>
  					</td>
  				</tr>
  			</c:forEach>
  		</tbody>
  	</table>
  	
  </body>
</html>
