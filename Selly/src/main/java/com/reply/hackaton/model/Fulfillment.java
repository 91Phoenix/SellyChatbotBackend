package com.reply.hackaton.model;

public class Fulfillment {
	
	private String speech;
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
	public Message[] getMessages() {
		return messages;
	}
	public void setMessages(Message[] messages) {
		this.messages = messages;
	}
	private Message[] messages;

}
