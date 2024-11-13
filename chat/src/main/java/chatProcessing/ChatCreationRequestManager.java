package chatProcessing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import javax.servlet.http.HttpSession;

import services.ChatService;
import view.Lab;

public class ChatCreationRequestManager {
	public static synchronized ChatRequest newRequest(HttpSession session,ChatCreationWebSocket socket) {
		ChatRequest nR = new ChatRequest(session);
		nR.subscribe(socket);
		chatRequests.add(nR);
		process();
		return nR;
	}
	
	private static HashSet<ChatRequest> chatRequests = new HashSet<>();
	
	private static synchronized void process() {
		if(chatRequests.size()>=2) {
			ArrayList<ChatRequest> requests = new ArrayList<>();
			
			Iterator<ChatRequest> iterator = chatRequests.iterator();
			while (iterator.hasNext()) {
				ChatRequest e = iterator.next();
				if (e == null) { 
					iterator.remove();
				} 
					else if (requests.size() < 2){
						requests.add(e);
					} 
				else { 
					break;
					}
			}
			ChatRequest firstReq = requests.getFirst();
			ChatRequest secondReq = requests.getLast();
			ChatService chatService = new ChatService(firstReq.session,firstReq.session.getServletContext());
			chatService.createChat(secondReq.session);
			firstReq.apply();
			secondReq.apply();
			chatRequests.removeAll(requests);
		}
	}
	
}
