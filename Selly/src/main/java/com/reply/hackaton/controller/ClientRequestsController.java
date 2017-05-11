package com.reply.hackaton.controller;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.service.ClientRequestManagerService;

@RequestMapping(method = RequestMethod.GET, value = "/clientRequest")
@RestController
public class ClientRequestsController {

		public static final Logger logger = Logger.getLogger(ClientRequestsController.class);

		@Autowired
		protected ClientRequestManagerService clienteRequestManagerService;
		
		
		public ClientRequestsController(ClientRequestManagerService clienteRequestManagerService) {
			this.clienteRequestManagerService= clienteRequestManagerService;
		}

		@RequestMapping(method = RequestMethod.POST, value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
		public String requestsController(@RequestParam("text")String text) throws JSONException {

			logger.info("handling a new request with text: " +text);
			AndroidClientResponse response = clienteRequestManagerService.manage(text);
			logger.info("clienteRequestManagerService produce an answer with text: " +response.getResponseText());
			Gson gson = new Gson();
			return gson.toJson(response);
		}
	
}
