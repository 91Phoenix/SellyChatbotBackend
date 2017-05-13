package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("smalltalk.agent.can_you_help")
public class CanYouHelp implements IntentExecutor {

	@Override
	public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
		return apiAIResponse.getResult().getSpeech();
	}

}
