package chatProcessing;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import javax.servlet.http.HttpSession;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import view.Lab;

@ServerEndpoint(value = "/updateChat" , configurator = ChatServerConfigurator.class)
public class ChatUpdateWebSocket implements Subscriber<List<Lab>>{
	    private Session session;
	    private Subscription subscription;
	    @OnOpen
	    public void onOpen(Session session, EndpointConfig config) {
	        this.session = session;
	        this.session.setMaxIdleTimeout(300000);
	        HttpSession userSession =(HttpSession) config.getUserProperties().get(HttpSession.class.getName());
	        ChatMap map = (ChatMap)userSession.getAttribute("userChats");
	        map.subscribe(this);
	    }

	    @OnClose
	    public void onClose(Session session) {
	    	this.session = null;
	    	this.subscription = null;
	    }

	    @OnMessage
	    public void onMessage(Session session, String message) {
	    	
	    }

	    @OnError
	    public void onError(Session session, Throwable throwable) {
	    	throwable.printStackTrace();
	    }


	    public void sendChatUpdates(List<Lab> item) throws IOException, EncodeException {
	    	ObjectMapper objM = new ObjectMapper();
	    	session.getBasicRemote().sendText(objM.writeValueAsString(item));
	    }

		@Override
		public void onSubscribe(Subscription subscription) {
			this.subscription = subscription; 
			subscription.request(1);
		}

		@Override
		public void onNext(List<Lab> item) {
			System.out.println("Received chat data: " + item);
			try {
				sendChatUpdates(item);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (EncodeException e) {
				e.printStackTrace();
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
