package com.reply.hackaton.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.lang3.StringUtils;
import com.reply.hackaton.model.AndroidClientResponse;

@Service
public class ClientRequestManagerService {
	
	public static final Logger logger = Logger.getLogger(ClientRequestManagerService.class);
	
	private static final String API_URL= "https://api.api.ai/v1/query";
	private static final String LANGUAGE = "it";
	private static final String VERSION = "LANGUAGE";
	//FIXME
	private static final String authorization = "Bearer FIXME";
	
	private static final Map<String, Runnable> FUNCTIONS = new HashMap<String, Runnable>();
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	IntentImplementation intenImplementation;
	
	public ClientRequestManagerService(){
		FUNCTIONS.put("TurnOffSMS", intenImplementation::turnOffSMS);
		FUNCTIONS.put("TurnOnSMS", intenImplementation::turnOnSMS);
	}

	public AndroidClientResponse manage(String text) throws JSONException {
		
		AndroidClientResponse response= new AndroidClientResponse();
		JSONObject request = new JSONObject();
		request.put("query", text);
		request.put("v", VERSION);
		request.put("lang", LANGUAGE);
		request.put("sessionId", "5");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authorization);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(),headers);
		/*At the moment the answer is the whole Api.ai response.*/
		String apiAIResponse = restTemplate.postForObject(API_URL, entity,String.class);
		String intentName= StringUtils.EMPTY;
		//extracts the intent calculated from Api.ai
		// intentName = SOME CODE;
		//Invokes the proper java function in order to implement the business logic
		FUNCTIONS.get(intentName).run();
		//response.setResponseText(retrieves the result from the intent business logic implementation and formulate the answer)
		return response;
	}

}
