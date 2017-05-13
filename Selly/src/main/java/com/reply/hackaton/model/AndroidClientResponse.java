package com.reply.hackaton.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("response")
public class AndroidClientResponse {
	
	private String responseText;

	private String responseImageName; //Name use to brutally retrieve a png in he mobile app

	private String responseImageLink; //clickable URL for the User

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public String getResponseImageName() {
		return responseImageName;
	}

	public void setResponseImageName(String responseImageName) {
		this.responseImageName = responseImageName;
	}

	public String getResponseImageLink() {
		return responseImageLink;
	}

	public void setResponseImageLink(String responseImageLink) {
		this.responseImageLink = responseImageLink;
	}
}
