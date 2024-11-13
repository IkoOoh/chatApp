package filters;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*;

import services.UserService; 
  
public class AuthorizationFilter implements Filter 
{ 
    private FilterConfig config = null; 
    private boolean active = false; 

    public void init (FilterConfig config) throws ServletException 
    { 
        this.config = config; 
        String act = config.getInitParameter("active"); 
        if (act != null) 
            active = (act.toUpperCase().equals("TRUE")); 
    } 

    public void doFilter (ServletRequest request, ServletResponse response, 
                          FilterChain chain) throws IOException, ServletException 
    { 
        if (active){ 
        	try{
            UserService userService = new UserService( ((HttpServletRequest)request) );
            if(!userService.isAuthorized()){
            	((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN);
            	return;
            }
        	}catch(Exception e){
        		e.printStackTrace();
        	}
        } 
        chain.doFilter(request, response); 
    } 

    public void destroy() 
    { 
        config = null; 
    } 
} 