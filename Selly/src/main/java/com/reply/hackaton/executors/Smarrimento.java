package com.reply.hackaton.executors;

import org.springframework.stereotype.Service;

import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("smarrimento")
public class Smarrimento implements IntentExecutor {

	@Override
	public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
		return apiAIResponse.getResult().getSpeech();
	}

}
