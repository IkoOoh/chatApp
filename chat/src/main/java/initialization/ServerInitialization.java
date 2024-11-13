package initialization;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import chatProcessing.ActiveChatsMap;
import chatProcessing.ChatCreationRequestManager;

@WebListener
public class ServerInitialization implements ServletContextListener{
	    @Override
	    public void contextInitialized(ServletContextEvent sce) {
	    	ActiveChatsMap acMap = new ActiveChatsMap();
	    	sce.getServletContext().setAttribute("activeChatsMap", acMap);
	    }

}
