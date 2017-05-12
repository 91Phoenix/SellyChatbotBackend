package com.reply.hackaton.model;

import java.util.Map;

public class PostContext {
	
	private String name;
	private int lifespan;
	private Map<String,String> parameters;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLifespan() {
		return lifespan;
	}
	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	

}
