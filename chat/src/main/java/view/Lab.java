package view;

import java.io.Serializable;

public class Lab implements Serializable{
	private static final long serialVersionUID = -2492869954843766646L;
	public String username;
	public int unreadMessagesCount;
	public String lastMessage;
	public Lab(){}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUnreadMessagesCount() {
		return unreadMessagesCount;
	}
	public void setUnreadMessagesCount(int unreadMessagesCount) {
		this.unreadMessagesCount = unreadMessagesCount;
	}
	public String getLastMessage() {
		return lastMessage;
	}
	public void setLastMessage(String lastMessage) {
		this.lastMessage = lastMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	};
}
