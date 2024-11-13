package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chatProcessing.ChatMap;

@WebServlet(name = "ChatBarServlet")
public class ChatBarServlet extends HttpServlet {

	private static final long serialVersionUID = -2087847758024062204L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        	try{
            	HttpSession session = request.getSession(false);
            	ChatMap userChats =  (ChatMap)session.getAttribute("userChats");
            	System.out.println("request from session" + session.getId()+ " to display chats, number of chats= " + userChats.size());
            	request.setAttribute("userChats", userChats.getChatLabels());
            	request.getRequestDispatcher("/mainPageComponents/chatBar.jsp").include(request, response)	;
            }catch(Exception e) {
            	response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            	e.printStackTrace();
            }
	}
}
