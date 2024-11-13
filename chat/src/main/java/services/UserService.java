package services;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {
	
	private HttpServletRequest request;
	
	public UserService(HttpServletRequest request) {
		this.request = request;
	}
	
	public Boolean Login(String username , String password) {
		if(username.equals("user1")&&password.equals("123")) {
			request.getSession().setAttribute("username",username);
			return true;
		}
		if(username.equals("user2")&&password.equals("123")) {
			request.getSession().setAttribute("username",username);
			return true;
		}
		return false;
	}
	
	public Boolean Register(String username , String password) {
		if(true) {
			request.getSession().setAttribute("username",username);
			return true;
		}
		return false;
	}
	
	public Boolean isAuthorized() {
		if(request.getSession(false) != null) {
			return request.getSession().getAttribute("username") != null;
		}
		return false;
	}
	
}
