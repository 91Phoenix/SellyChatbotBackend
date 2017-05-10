package com.reply.hackaton.model;

public interface IntentExecutorFactory {

	public IntentExecutor getIntentExecutor(String serviceName);
	
}
