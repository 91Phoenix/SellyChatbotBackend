package com.reply.hackaton.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("response")
public class AndroidClientResponse {
	
	private String responseText;

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

}
