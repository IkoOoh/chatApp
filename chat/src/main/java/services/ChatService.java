package services;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import chatProcessing.ActiveChatsMap;
import chatProcessing.ChatMap;
import sessionClasses.ChatSession;

public class ChatService {
	
	private static int chatCount = 0;
	
	private HttpSession session;
	
	private ServletContext servletContext;
	
	public ChatService(HttpSession session,ServletContext servletContext) {
		this.session = session;
		this.servletContext = servletContext;
	}
	
	public void initializeChatSession() {	
		ChatMap chatMap = getSessionChatMap();
		if(chatMap == null) {
			chatMap = new ChatMap();
			session.setAttribute("userChats", chatMap);
			System.out.println("created new chatSession");
			loadChats();
		}
	}
	
	public boolean deleteChat(ChatSession value) {
		ChatMap chatMap = getSessionChatMap();
		ActiveChatsMap activeChatsMap = getContextCatMap();
		chatMap.remove(value.getUsername());
		activeChatsMap.deleteChat(value);
		return false;
	}
	
	private ChatMap getSessionChatMap() {
		return (ChatMap)session.getAttribute("userChats");
	}
	private ActiveChatsMap getContextCatMap() {
		return (ActiveChatsMap)servletContext.getAttribute("activeChatsMap");
	}
	public void createChat(HttpSession session){
		ChatMap thisChatMap = getSessionChatMap();
		ActiveChatsMap ActiveChatsMap = getContextCatMap();
		ChatSession c = new ChatSession();
		c.setChatId(chatCount);
		c.setLastMessage("last msg "+chatCount);
		c.setUnreadMessagesCount(chatCount);
		c.setUsername((String)this.session.getAttribute("username"));
		
		ChatMap sesChatMap = (ChatMap)session.getAttribute("userChats");
		sesChatMap.put(c);
		ActiveChatsMap.putChat(c);
		
		c = new ChatSession();
		c.setChatId(chatCount);
		c.setLastMessage("last msg "+chatCount);
		c.setUnreadMessagesCount(chatCount);
		c.setUsername((String)session.getAttribute("username"));
		thisChatMap.put(c);
		ActiveChatsMap.putChat(c);
		chatCount++;
	}
	public void destroyChatSession() {
		ChatMap chatMap = getSessionChatMap();
		if(chatMap != null) {
			ActiveChatsMap activeChatsMap = getContextCatMap();
			chatMap.forEach((str,ses)->{
				activeChatsMap.deleteChatSession(ses);
			});
		}
		session.removeAttribute("userChats");
	}
	
	private void loadChats() {
		ChatMap chatMap = getSessionChatMap();
		ActiveChatsMap activeChatsMap = getContextCatMap();
		ChatSession c = new ChatSession();
		c.setChatId(55);
		c.setLastMessage("first msg");
		c.setUnreadMessagesCount(3);
		c.setUsername("user55");
		chatMap.put(c);
		activeChatsMap.putChat(c);
	}
	
}
