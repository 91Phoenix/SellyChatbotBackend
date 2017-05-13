package com.reply.hackaton.executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.model.User;
import com.reply.hackaton.repository.UserRepository;

@Service("GeoLocalization_Set")
public class GeoLocalizationSet implements IntentExecutor {

	@Autowired
	UserRepository users;

	@Override
	@Transactional
	public String execute(Response ApiAIResponse) {
		if (!ApiAIResponse.getResult().isActionIncomplete())
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
		
		if (ApiAIResponse.getResult().getResolvedQuery() == "Si"){
			resultUser.setGeoFencing(ApiAIResponse.getResult().getParameters().get("ZoneN"));
			return "Ok, I have enabled your card for " + ApiAIResponse.getResult().getParameters().get("ZoneN");
		}
		else {
			return "Ok, I will not change the geo-fencing settings of your card.";
		}
	}

}
