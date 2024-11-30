package com.ems.ixchange.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.ixchange.common.ChatRoom;
import com.ems.ixchange.common.Chatter;
import com.ems.ixchange.common.Message;

/**
 * Servlet implementation class MessageRenderController
 */
@WebServlet("/renderMessage")
public class MessageRenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageRenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession(false);
		String memberId = (String) session.getAttribute("memberId");
		ChatRoom chatRoom = null;
		Chatter chatter = null;
		Message[] messages = null;
		if(memberId != null){
			chatRoom = (ChatRoom) getServletContext().getAttribute("idea-xchange-chat-room");
			chatter = chatRoom.getChatter(memberId);
			if (chatRoom != null){
				long enteredAt = chatter.getEnteredInRoomAt();
				if (enteredAt != -1)
					messages = chatRoom.getMessages(enteredAt);					
				else
					messages = chatRoom.getMessages(chatter.getLoginTime());
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(messages != null && messages.length > 0){
			for (int i = 0; i < messages.length; i++){
				Message message = (Message) messages[i];
				String chatterId = message.getChatterId();
				String strmsg = message.getMessage();
				long time = message.getTimeStamp();
				Date date = new Date(time);
				if (chatterId.equalsIgnoreCase(memberId))
					out.write("<font face=\"Arial\" size=\"2\" color=\"blue\"><b>" + chatterId + " ["+ DateFormat.getTimeInstance().format(date)+ "]</b></font> " + strmsg+"<br>\n");
				else
					out.write("<font face=\"Arial\" size=\"2\"><b>"+chatterId + " ["+ DateFormat.getTimeInstance().format(date)+ "]</b></font> " + strmsg + "<br />\n");
			}
			out.write("<a name=\"current\"></a>");
		}else
			out.write("<font color=\"red\" face=\"Arial\" size=\"2\">There are currently no messages in idea exchange box.</font>");
		out.write("<a name=\"current\"></a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
