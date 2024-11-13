package MessageProcessing;

import java.util.ArrayList;
import java.util.HashSet;

import back.Message;

public class MessageSession {
	ArrayList<Message> messages;
	HashSet<UserMessagesSession> sessions;
	
	public void put(Message msg){
		messages.add(msg);
	}
	
	
}
