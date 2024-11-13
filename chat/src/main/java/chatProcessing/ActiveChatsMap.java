package chatProcessing;

import java.util.HashMap;
import java.util.HashSet;

import sessionClasses.ChatSession;

public class ActiveChatsMap {
	private HashMap<Integer,HashSet<ChatSession>> activeChats = new HashMap<>();
	public boolean containsChat(int id) {
		return activeChats.containsKey(id);
	}
	
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
	
	public boolean deleteChatSession(ChatSession chatSession) {
		HashSet<ChatSession> chatSessions =
				(HashSet<ChatSession> )activeChats.get(chatSession.getChatId());
		if(chatSessions!=null) {
			boolean flag = chatSessions.remove(chatSession);
			System.out.println("chat session inactive id:"+chatSession.getChatId());
			if(chatSessions.size()==0) {
				activeChats.remove(chatSession.getChatId());
				System.out.println("chat inactive id:"+chatSession.getChatId());
			}
			return flag;
		}else {
			return false;
		}
	}
	
	public boolean deleteChat(ChatSession chatSession) {
		return activeChats.remove(chatSession.getChatId()) != null;
	}
}
