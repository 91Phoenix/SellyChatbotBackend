package com.reply.hackaton.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.service.ClientRequestManagerService;

@RequestMapping(method = RequestMethod.GET, value = "/clientRequest")
public class ClientRequestsController {

		public static final Logger logger = Logger.getLogger(ClientRequestsController.class);

		@Autowired
		protected ClientRequestManagerService clienteRequestManagerService;
		
		
		public ClientRequestsController(ClientRequestManagerService clienteRequestManagerService) {
			this.clienteRequestManagerService= clienteRequestManagerService;
		}

		@RequestMapping(method = RequestMethod.GET, value = "/")
		public AndroidClientResponse requestsController(@RequestParam("text")String test) {

			logger.info("handling a new request with text: " +test);
			AndroidClientResponse response = clienteRequestManagerService.manage();
			logger.info("clienteRequestManagerService produce an answer with text: " +response.getResponseText());
			
			return response;
		}
	
}
