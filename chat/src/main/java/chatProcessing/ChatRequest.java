package chatProcessing;

import java.util.concurrent.SubmissionPublisher;

import javax.servlet.http.HttpSession;

public class ChatRequest extends SubmissionPublisher<String>{
	public HttpSession session;
	public ChatRequest(HttpSession session) {
		this.session = session;
	}
	public void apply() {
		submit((String)session.getAttribute("username"));
	}
}
