package initialization;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import services.ChatService;

@WebListener
public class ChatInitializer implements HttpSessionListener{

	    @Override
	    public void sessionCreated(HttpSessionEvent se) {
	    	ChatService chatService = new ChatService(se.getSession() ,se.getSession().getServletContext());
	    	chatService.initializeChatSession();
	    }
}
