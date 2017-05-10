package com.reply.hackaton.executors;

import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("smalltalk.agent.can_you_help")
public class CanYouHelp implements IntentExecutor {

	@Override
	public String execute(Response ApiAIResponse) {
		return ApiAIResponse.getResult().getSpeech();
	}

}
