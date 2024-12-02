<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%><%@ page isErrorPage="false" import="java.util.Set,java.util.Iterator,java.util.Map,com.ems.ixchange.common.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iXchange Message Type</title>
<script type="text/javascript">
window.onload = function() {
	document.getElementById("chat-msg-id").focus();
};
</script>
</head>
<body>
<%String memberId = (String) session.getAttribute("memberId");
if (memberId != null){
	ChatRoom chatRoom = (ChatRoom) getServletContext().getAttribute("idea-xchange-chat-room");
	if ( chatRoom != null){
		String msgText = null;
		if(request.getParameter("chat-msg-text") != null){
			msgText = request.getParameter("chat-msg-text").trim();
			chatRoom.addMessage(new Message(memberId, msgText, new java.util.Date().getTime()));
		}
	}
}%>
<form name="chat-msg-form" action="type-msg.jsp" method="get">
	<input type="text" name="chat-msg-text" id="chat-msg-id" maxlength="300" style="width:290px; height:30px" autocomplete="off">
	<input type="hidden" name="chat-messanger" value="<%=session.getAttribute("memberId") %>">
	<input type="submit" name="chat-msg-submit" value="Send Message" 
		style="border:1px solid #f44c0e;color:#fff;background:#f44c0e;padding:10px 13px;border-radius:3px;font-weight:bold;">
</form>
</body>
</html>