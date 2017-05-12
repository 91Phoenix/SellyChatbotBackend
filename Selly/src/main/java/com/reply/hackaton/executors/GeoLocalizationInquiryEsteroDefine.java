package com.reply.hackaton.executors;

import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;

@Service("GeoLocalization_InquiryEsteroDefine")
public class GeoLocalizationInquiryEsteroDefine extends GeoLocalizationInquiry {

	@Override
	public String execute(Response ApiAIResponse) {
		ApiAIResponse.getResult().getParameters().get(ApiAIResponse.getResult().getParameters().get("ForeignCountry"));
		return super.execute(ApiAIResponse);
	}
}
