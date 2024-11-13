package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import view.Lab;

@WebServlet(name = "HelpServlet")
public class HelpServlet extends HttpServlet {
	private static final long serialVersionUID = 5239185271359793548L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        	try{
            	String username = request.getParameter("username");
            	int unreadMessagesCount =  Integer.parseInt(request.getParameter("unreadMessagesCount"));
            	String lastMessage = request.getParameter("lastMessage");
            	Lab chatO = new Lab();
            	chatO.username = username;
            	chatO.unreadMessagesCount = unreadMessagesCount;
            	chatO.lastMessage = lastMessage;
            	request.setAttribute("lab", chatO);
            	request.getRequestDispatcher("/mainPageComponents/lab.jsp").include(request, response)	;
            }catch(Exception e) {
            	response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            	e.printStackTrace();
            }
	}
}
