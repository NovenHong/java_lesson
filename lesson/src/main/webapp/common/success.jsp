<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>success</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

  </head>
  
  <body>
  	<h3>success</h3>
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
			location.href="${url}";
		}
	}, 1000)
</script>
