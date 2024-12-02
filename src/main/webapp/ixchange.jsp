<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iXchange Platform</title>
<style type="text/css">
.frame-style { 
	border: 1px gray solid; 
}
</style>
</head>
<frameset rows="90,*" frameborder="0">
	<frame src="app-header.jsp" frameborder="0" scrolling="no" name="iXchangeHeaderWin">
	<frameset cols="*,190">
		<frameset rows="*,60">
			<frame src="display-msgs.jsp#current" frameborder="0" scrolling="yes" name="iXchangeDisplayChatWin" class="frame-style">
			<frame src="type-msg.jsp" frameborder="0" scrolling="no" name="iXchangeTypeMsgWin" class="frame-style">
		</frameset>
		<frame src="ol-buddies.jsp" frameborder="0" scrolling="yes" name="iXchangeOnlineBuddyWin" class="frame-style">
	</frameset>
</frameset>
<noframes>
<h2>This idea exchange platform requires a browser with frames support.</h2>
</noframes>
</html>