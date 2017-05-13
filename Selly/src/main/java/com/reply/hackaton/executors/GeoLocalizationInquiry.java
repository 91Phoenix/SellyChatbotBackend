package com.reply.hackaton.executors;

import com.reply.hackaton.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.repository.UserRepository;

@Service("GeoLocalization_Inquiry")
public class GeoLocalizationInquiry implements IntentExecutor {

	private static final String TRAVEL_INSURANCE = "travel_insurance";
	private static final String TRAVEL_INSURANCE_WEB_SITE = "https://www.travelexinsurance.com";
	@Autowired
	UserRepository users;
	
	@Override
	public String execute(Response ApiAIResponse, AndroidClientResponse androidClientResponse) {
		if (ApiAIResponse.getResult().isActionIncomplete())
			return ApiAIResponse.getResult().getSpeech();
		Iterable<User> iterable = users.findAll();
		User resultUser = null;
		for (User u : iterable) {
			if (u.getPAN().equals("525500******9045")){
				resultUser = u;
				break;
			}
		}
		assert(resultUser != null);

		androidClientResponse.setResponseImageLink(TRAVEL_INSURANCE_WEB_SITE);
		androidClientResponse.setResponseImageName(TRAVEL_INSURANCE);
		
		if(resultUser.getGeoFencing().equals("World")){
			return "Puoi pagare con la tua carta in tutto il mondo.";
		}
		else if(resultUser.getGeoFencing().equals("Europe")){
			if (ApiAIResponse.getResult().getParameters().get("ZoneN") == "World"){
				return "La tua carta non é abilitata ai pagamenti in tutto il mondo."; 
			}
			else {
				return "Puoi pagare con la tua carta solo in " + (ApiAIResponse.getResult().getParameters().get("ZoneN").equals("Europe") ? "Europa" : "Italia" ) + ".";
			}
		}
		else {
			return "Puoi utilizzare la tua carta per pagare in Italia.";
		}
	}

}
