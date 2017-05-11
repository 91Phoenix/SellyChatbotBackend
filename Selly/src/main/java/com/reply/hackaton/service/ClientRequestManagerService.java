package com.reply.hackaton.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.model.IntentExecutorFactory;
import com.reply.hackaton.model.Response;

@Service
public class ClientRequestManagerService {
	
	public static final Logger logger = Logger.getLogger(ClientRequestManagerService.class);
	
	private static final String API_URL= "https://api.api.ai/v1/query";
	private static final String LANGUAGE = "it";
	private static final String VERSION = "20150910";
	//
	//FIXME 
	private static final String authorization = "Bearer FIXME ";
	
	@Autowired
	RestTemplate restTemplate;
	
	private IntentExecutorFactory intentExecutorFactory;
	
	@Autowired
	public ClientRequestManagerService(IntentExecutorFactory intentExecutorFactory){
		this.intentExecutorFactory=intentExecutorFactory;
	}

	public AndroidClientResponse manage(String text) throws JSONException {
		
		AndroidClientResponse response= new AndroidClientResponse();
		//prepares the Api.ai request
		HttpEntity<String> entity = requestsPreparer(text);
		//invokes and Wraps the ApiAIResponse into a Java Object
		Response apiAiResponse = jsonToApiAIResponseTransformer(entity);
		String action = apiAiResponse.getResult().getAction();
		String intentName = null != action ? action : StringUtils.EMPTY;
		//Invokes the proper java function in order to implement the business logic
		response.setResponseText(intentExecutorFactory.getIntentExecutor(intentName).execute(apiAiResponse));
		return response;
	}

	private Response jsonToApiAIResponseTransformer(HttpEntity<String> entity) {
		String apiAIResponse = restTemplate.postForObject(API_URL, entity,String.class);
		Gson gson = new Gson();
		Response apiAiResponse = gson.fromJson(apiAIResponse, Response.class);
		return apiAiResponse;
	}

	private HttpEntity<String> requestsPreparer(String text) throws JSONException {
		JSONObject request = new JSONObject();
		request.put("query", text);
		request.put("v", VERSION);
		request.put("lang", LANGUAGE);
		request.put("sessionId", "5");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authorization);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(),headers);
		return entity;
	}

}
