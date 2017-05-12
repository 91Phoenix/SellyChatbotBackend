package com.reply.hackaton.executors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.model.TransactionHistory;
import com.reply.hackaton.model.User;
import com.reply.hackaton.repository.TransactionHistoryRepository;
import com.reply.hackaton.repository.UserRepository;

@Service("GeoLocalization_Inquiry")
public class GeoLocalizationInquiry implements IntentExecutor {

	@Autowired
	UserRepository users;
	
	@Override
	public String execute(Response ApiAIResponse) {
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
