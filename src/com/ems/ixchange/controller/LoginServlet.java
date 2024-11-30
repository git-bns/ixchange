package com.ems.ixchange.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.ixchange.common.ChatRoom;
import com.ems.ixchange.common.Chatter;

@WebServlet("/startIXchange")
public class LoginServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** This method just redirects user to a login page.*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String memberId = request.getParameter("memberId").trim().toUpperCase();
		String name = request.getParameter("name").trim();
		String sex = request.getParameter("sex").trim();
		
		if (memberId != null && memberId.indexOf(" ") == -1 && sex != null)
		{
			try
			{
				ChatRoom chatRoom = null;
				chatRoom = (ChatRoom) getServletContext().getAttribute("idea-xchange-chat-room");
				
				if(chatRoom == null){
					chatRoom = new ChatRoom("ideaXxchangeChatRoom", "This is the common chat room for idea exchange.");
					getServletContext().setAttribute("idea-xchange-chat-room", chatRoom);
				}
				
				boolean chatterexists = chatRoom.chatterExists(memberId);
				if (chatterexists)
					System.out.println("Error!! Please enable single instance application login.");
				else{
					HttpSession session = request.getSession(true);
					int timeout = 600; // 10 minutes
					session.setMaxInactiveInterval(timeout);
					session.setAttribute("memberId", memberId);
					Chatter chatter = new Chatter(memberId, name, sex, new java.util.Date().getTime());
					chatRoom.addChatter(chatter);
					
					response.sendRedirect("ixchange.jsp");

				}
			}catch(Exception exception){
				System.out.println("Exception thrown in LoginServlet: " + exception.getMessage());
				exception.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		}
		else
			response.sendRedirect("index.jsp");
	}
	/** Performs some validation and if everything is ok sends user to a page which displays a list of
	* rooms available.
	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}