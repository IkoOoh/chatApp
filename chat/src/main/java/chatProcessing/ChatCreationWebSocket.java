package chatProcessing;

import java.io.IOException;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

@ServerEndpoint(value = "/createNewChat" , configurator = ChatServerConfigurator.class)
public class ChatCreationWebSocket implements Subscriber<String>{
		private Session session;
		private Subscription subscription;
		ChatRequest currentRequest;
	    @OnOpen
	    public void onOpen(Session session, EndpointConfig config) {
	    	 this.session = session;
		        this.session.setMaxIdleTimeout(300000);
		        HttpSession userSession =(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
		        currentRequest = ChatCreationRequestManager.newRequest(userSession,this);
	    }

	    @OnClose
	    public void onClose(Session session) {
	    	this.session = null;
	    	this.subscription = null;
	    	this.currentRequest = null;
	    }

	    @OnMessage
	    public void onMessage(Session session, String message) {
	    	
	    }

	    @OnError
	    public void onError(Session session, Throwable throwable) {

	    }

		@Override
		public void onSubscribe(Subscription subscription) {
			this.subscription = subscription; 
			subscription.request(1);
		}

		@Override
		public void onNext(String item) {
		    System.out.println("Chat created: " + item);
		    try {
		        ObjectMapper objM = new ObjectMapper();
		        session.getBasicRemote().sendText(objM.writeValueAsString(item));
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Chat creation complete"));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    subscription.request(1);
		}


		@Override
		public void onError(Throwable throwable) {
			System.out.println("Error occurred: " + throwable.getMessage());
			
		}

		@Override
		public void onComplete() {
		}
}
