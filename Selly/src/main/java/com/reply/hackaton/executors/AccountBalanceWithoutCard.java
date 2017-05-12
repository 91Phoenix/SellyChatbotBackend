package com.reply.hackaton.executors;

import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("chiedere_numero_carta")
public class AccountBalanceWithoutCard implements IntentExecutor {

	@Override
	public String execute(Response ApiAIResponse) {
		return ApiAIResponse.getResult().getSpeech();
	}

}
