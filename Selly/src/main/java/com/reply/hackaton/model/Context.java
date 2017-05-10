package com.reply.hackaton.model;

import java.util.HashMap;

public class Context {
	private String name;
	private HashMap<String,String> parameters;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}
	public int getLifespan() {
		return lifespan;
	}
	public void setLifespan(int lifespan) {
		this.lifespan = lifespan;
	}
	private int lifespan;

}
