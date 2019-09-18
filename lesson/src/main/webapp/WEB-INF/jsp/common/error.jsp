<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>错误提示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

  </head>
  
  <body>
  	<h3>错误提示</h3>
  	<h4>${message}</h4>
  	<span class="timeout">3</span>秒后跳转...
  </body>
</html>

<script type="text/javascript">

	var timeout = $(".timeout").text();
	
	var timer = setInterval(function() {
		timeout--;
		$(".timeout").text(timeout);
		if(timeout == 0){
			clearInterval(timer);
			<c:choose>
		  		<c:when test="${url}">
		  			location.href="${APP_PATH}/${url}";
		  		</c:when>
		  		<c:otherwise>
		  			window.history.back(-1);
		  		</c:otherwise>
		  	</c:choose>
		}
	}, 1000)
</script>
