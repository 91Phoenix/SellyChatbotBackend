package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import org.springframework.stereotype.Service;

import com.reply.hackaton.model.Response;

@Service("GeoLocalization_InquiryEsteroDefine")
public class GeoLocalizationInquiryEsteroDefine extends GeoLocalizationInquiry {

	@Override
	public String execute(Response ApiAIResponse, AndroidClientResponse androidClientResponse) {
		ApiAIResponse.getResult().getParameters().get(ApiAIResponse.getResult().getParameters().get("ForeignCountry"));
		return super.execute(ApiAIResponse, androidClientResponse);
	}
}
