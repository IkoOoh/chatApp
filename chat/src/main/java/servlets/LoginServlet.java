package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.UserService;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 4118563311878631458L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        request.setAttribute("error", false);
        
        if(request.getRequestURI().equals(request.getContextPath() +"/logout")) {
			HttpSession session = request.getSession(false);
			if(session!=null)
				session.invalidate();
			response.sendRedirect(request.getContextPath() +"/Welcome.jsp");
			return;
		}
        
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        try {
        String username =  (String)request.getParameter("username");
		String password =  (String)request.getParameter("password");
		UserService userService = new UserService(request);
		if(userService.Login(username, password)) {
			response.sendRedirect(request.getContextPath() + "/mainPage");
		}else{
			 request.setAttribute("error", true);
			 request.getRequestDispatcher("/Login.jsp").forward(request, response);
		};
        }catch(Exception e){
        	e.printStackTrace();
        	response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
        
	}
}
