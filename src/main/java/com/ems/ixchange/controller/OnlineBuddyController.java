package com.ems.ixchange.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.ixchange.common.ChatRoom;
import com.ems.ixchange.common.Chatter;

/**
 * Servlet implementation class OnlineBuddyController
 */
@WebServlet("/getOlBuddy")
public class OnlineBuddyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineBuddyController() {
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
		ChatRoom chatRoom = (ChatRoom) getServletContext().getAttribute("idea-xchange-chat-room");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<div style=\"background-color:gray;color:white;padding:5px;\">" + chatRoom.getNoOfChatters() + " Online iXchage Members</div>");
		Chatter[] chatters = chatRoom.getChattersArray();
		for(int i = 0; i < chatters.length; i++){
			if (chatters[i].getName().equals(memberId))
				out.write("<font face=\"Arial\" size=\"2\" color=\"blue\">[" + chatters[i].getMemberId().toUpperCase() + "] " + chatters[i].getName() + "<br /></font>");
			else
				out.write("<font face=\"Arial\" size=\"2\">[" + chatters[i].getMemberId().toUpperCase() + "] " + chatters[i].getName() + "<br /></font>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
