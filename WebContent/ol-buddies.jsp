<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iXchange Online Buddies</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
function autoRefresh_div() {
	$.ajax({
		type : "GET",
		url : "getOlBuddy",
		success : function(response) {
			$("#online-buddy-div-id").html(response);
		}
	});
}
setInterval('autoRefresh_div()', 3000); // refresh div after 3 secs
</script>
</head>
<body>
<div id="online-buddy-div-id" style="display: table-cell;background-color:aqua;text-align: center;">
</div>
</body>
</html>