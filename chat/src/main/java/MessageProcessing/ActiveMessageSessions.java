package MessageProcessing;

import java.util.HashMap;
import java.util.HashSet;

import sessionClasses.ChatSession;

public class ActiveMessageSessions {
	private HashMap<Integer,HashSet<ChatSession>> activeChats = new HashMap<>();
	
	public boolean putChat(ChatSession chatSession) {
		HashSet<ChatSession> chatSessions =
				(HashSet<ChatSession> )activeChats.get(chatSession.getChatId());
		if(chatSessions!=null) {
			System.out.println("new session added to eixisted active chat with id: "+chatSession.getChatId());
			return chatSessions.add(chatSession);
		}else {
			System.out.println("new active chat id: "+chatSession.getChatId());
			HashSet<ChatSession> newChatSet = new HashSet<>();
			newChatSet.add(chatSession);
			activeChats.put(chatSession.getChatId(),newChatSet);
			return true;
		}
	}
}
