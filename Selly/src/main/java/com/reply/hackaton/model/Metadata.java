package com.reply.hackaton.model;

public class Metadata {
	private String intentId;
	private String webhookUsed;
	private String webhookForSlotFillingUsed;
	private String intentName;
	private Context[] inputContexts;
	private Context[] outputContexts;
	private String[] contexts;
	
	
	public String getIntentId() {
		return intentId;
	}
	public Context[] getInputContexts() {
		return inputContexts;
	}
	public void setInputContexts(Context[] inputContexts) {
		this.inputContexts = inputContexts;
	}
	public Context[] getOutputContexts() {
		return outputContexts;
	}
	public void setOutputContexts(Context[] outputContexts) {
		this.outputContexts = outputContexts;
	}
	public String[] getContexts() {
		return contexts;
	}
	public void setContexts(String[] contexts) {
		this.contexts = contexts;
	}
	public void setIntentId(String intentId) {
		this.intentId = intentId;
	}
	public String getWebhookUsed() {
		return webhookUsed;
	}
	public void setWebhookUsed(String webhookUsed) {
		this.webhookUsed = webhookUsed;
	}
	public String getWebhookForSlotFillingUsed() {
		return webhookForSlotFillingUsed;
	}
	public void setWebhookForSlotFillingUsed(String webhookForSlotFillingUsed) {
		this.webhookForSlotFillingUsed = webhookForSlotFillingUsed;
	}
	public String getIntentName() {
		return intentName;
	}
	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

}
