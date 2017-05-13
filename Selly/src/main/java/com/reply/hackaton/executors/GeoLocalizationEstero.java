package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("GeoLocalization_InquiryEstero")
public class GeoLocalizationEstero implements IntentExecutor {	
	@Override
	public String execute(Response ApiAIResponse, AndroidClientResponse androidClientResponse) {
		return ApiAIResponse.getResult().getSpeech();
	}
}
