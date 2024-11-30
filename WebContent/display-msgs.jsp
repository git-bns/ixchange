<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iXchange Chat Display</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
function autoRefresh_div() {
	$.ajax({
		type : "GET",
		url : "renderMessage",
		success : function(response) {
			$("#chat-msgs-div-id").html(response);
		}
	});
}
setInterval('autoRefresh_div()', 1000); // refresh div after 1 secs
</script>
</head>
<body>
<div id="chat-msgs-div-id"></div> 
</body>
</html>