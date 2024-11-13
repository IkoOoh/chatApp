package view;

import java.io.Serializable;
import java.sql.Timestamp;

public class MessageLab implements Serializable{
	private static final long serialVersionUID = 2182082355280274992L;
	private boolean isYour;
	private String text;
	private Timestamp sendDate;
	public MessageLab() {}
	public boolean isYour() {
		return isYour;
	}
	public void setYour(boolean isYour) {
		this.isYour = isYour;
	}
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
	
}
