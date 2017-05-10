package com.reply.hackaton.model;

import java.util.HashMap;

public class Result {
	
	private String source;
	private String resolvedQuery;
	private String action;
	private boolean actionIncomplete;
	private HashMap<String,String> parameters;
	private Context[] contexts;
	private Fulfillment fulfillment;
	private double score;
	private Metadata metadata;
	private String speech;
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getResolvedQuery() {
		return resolvedQuery;
	}
	public void setResolvedQuery(String resolvedQuery) {
		this.resolvedQuery = resolvedQuery;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public boolean isActionIncomplete() {
		return actionIncomplete;
	}
	public void setActionIncomplete(boolean actionIncomplete) {
		this.actionIncomplete = actionIncomplete;
	}
	public HashMap<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}
	public Context[] getContexts() {
		return contexts;
	}
	public void setContexts(Context[] contexts) {
		this.contexts = contexts;
	}
	public Fulfillment getFulfillment() {
		return fulfillment;
	}
	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public String getSpeech() {
		return speech;
	}
	public void setSpeech(String speech) {
		this.speech = speech;
	}
}
