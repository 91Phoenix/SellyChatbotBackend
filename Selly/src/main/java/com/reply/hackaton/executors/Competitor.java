package com.reply.hackaton.executors;

import org.springframework.stereotype.Service;

import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("Competitor")
public class Competitor implements IntentExecutor {

	@Override
	public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
		return apiAIResponse.getResult().getSpeech();
	}

}
