package chatProcessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import sessionClasses.ChatSession;
import view.Lab;

public class ChatMap extends SubmissionPublisher<List<Lab>>{
	private HashMap<String, ChatSession> chatMap = new HashMap<>();

	public ChatMap(){};
	
	public boolean containsKey(Object key) {
		return chatMap.containsKey(key);
	}

	public ChatSession put(ChatSession value) {
		ChatSession chatSession = chatMap.put(value.getUsername(), value);
		submit(getChatLabels());
		return chatSession;
	}

	public void clear() {
		chatMap.clear();
	}
	public void update(ChatSession value){
		chatMap.put(value.getUsername(),value);
		submit(getChatLabels());
	}
	public boolean containsValue(Object value) {
		return chatMap.containsValue(value);
	}
	
	public List<Lab> getChatLabels(){
		return chatMap.values().stream().map(el->{
			Lab label = new Lab();
			label.lastMessage = el.getLastMessage();
			label.unreadMessagesCount = el.getUnreadMessagesCount();
			label.username = el.getUsername();
			return label;
		}).collect(Collectors.toCollection(ArrayList::new));
	}

	public void forEach(BiConsumer<? super String, ? super ChatSession> action) {
		chatMap.forEach(action);
		submit(getChatLabels());
	}

	public ChatSession remove(String key) {
		ChatSession chatSession = chatMap.remove(key);
		submit(getChatLabels());
		return chatSession;
	}

	public int size() {
		return chatMap.size();
	}

	public ChatSession get(String key) {
		return chatMap.get(key);
	}
}
