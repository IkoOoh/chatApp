package sessionClasses;

public class ChatSession {
	private int chatId;
	
	private String username;
	
	private String lastMessage;
	
	private int unreadMessagesCount;
	
	public ChatSession(){}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastMessage() {
		return lastMessage;
	}

	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}

	public int getUnreadMessagesCount() {
		return unreadMessagesCount;
	}

	public void setUnreadMessagesCount(int unreadMessagesCount) {
		this.unreadMessagesCount = unreadMessagesCount;
	}
	
}
