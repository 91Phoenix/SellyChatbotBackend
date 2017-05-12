package com.reply.hackaton.Utilities;

import java.time.Month;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.reply.hackaton.service.ClientRequestManagerService;

public class Utility {

	public static final Logger logger = Logger.getLogger(ClientRequestManagerService.class);

	private static final String API_URL = "https://api.api.ai/v1/contexts";
	private static final String LANGUAGE = "it";
	private static final String VERSION = "20150910";
	//
	// FIXME
	private static final String authorization = "Bearer fbacdb128cb24b17af0fb5ce34a69989";

	public static HttpEntity<String> requestsPreparer(String sessionId, String name) throws JSONException {
		JSONObject request = new JSONObject();
		request.put("lifespan", 999);
		request.put("name", name);
		request.put("query", new HashMap<String, String>());
		request.put("sessionId", sessionId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", authorization);
		// headers.add("Accept", MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		return entity;
	}

	public static String transformItalianInEnglishMonths(String date) {
		
		switch (date.toLowerCase()){
			case"gennaio":
				return "january";
			case"febbraio":
				return "february";
			case"marzo":
				return "march";
			case"aprile":
				return "april";
			case "maggio":
				return "may";
			case "giugno":
				return "june";
			case"luglio":
				return "july";
			case"agosto":
				return "august";
			case "settembre":
				return "september";
			case"ottobre":
				return "october";
			case"novembre":
				return "november";
			case"dicembre":
				return "december";
			default:
				return "";
		}
		
	}
}
