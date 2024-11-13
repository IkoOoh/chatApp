package back;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable{
	private static final long serialVersionUID = 0;
	private String author;
	private String text;
	private Timestamp sendDate;
	public Message() {}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Timestamp getSendDate() {
		return sendDate;
	}
	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
