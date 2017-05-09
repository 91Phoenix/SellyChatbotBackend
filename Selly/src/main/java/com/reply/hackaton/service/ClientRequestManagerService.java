package com.reply.hackaton.service;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reply.hackaton.model.AndroidClientResponse;

@Service
public class ClientRequestManagerService {
	
	public static final Logger logger = Logger.getLogger(ClientRequestManagerService.class);
	
	private static final String API_URL= "https://api.api.ai/v1/query";
	private static final String LANGUAGE = "it";
	private static final String VERSION = "LANGUAGE";
	private static final String authorization = "Bearer def5eba71ada4038921bc7eae00895cf";
	
	@Autowired
	RestTemplate restTemplate;

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
		response.setResponseText( restTemplate.postForObject(API_URL, entity,String.class));
		return response;
	}

}
