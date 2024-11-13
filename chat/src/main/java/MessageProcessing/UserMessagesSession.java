package MessageProcessing;

import java.io.IOException;
import java.util.concurrent.SubmissionPublisher;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import back.Message;
import chatProcessing.ChatMap;
import chatProcessing.ChatServerConfigurator;
import view.MessageLab;

@ServerEndpoint(value = "/createNewChat" , configurator = ChatServerConfigurator.class)
public class UserMessagesSession extends SubmissionPublisher<Message> {
	
	private int offset = -1;
	int chatId;
	Session session;
	String username;
	public void showHistory() {
		
	}
	public void showNew(MessageLab message) {
		ObjectMapper objM = new ObjectMapper();
        try {
			session.getBasicRemote().sendText(objM.writeValueAsString(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void postNew(String message){
		Message msg = new Message();
		msg.setText(message);
		submit(msg);
	}
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws IOException {
		HttpSession userSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		ChatMap userChats = (ChatMap)userSession.getAttribute("userChats");
		String query = session.getQueryString();
		if (query != null && query.contains("username=")) 
		{
			username = query.split("=")[1];
			chatId = userChats.get(username).getChatId();	
		}
		if(chatId == -1) {
			session.close();
			return;
		}
	    this.session = session;
		showHistory();
	}

	@OnClose
	public void onClose(Session session) {
		this.session = null;
	}

	@OnMessage
	public void onMessage(Session session, String message) {
	    	
	}

	@OnError
	 public void onError(Session session, Throwable throwable) {

	}

	
	
}
