package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.repository.UserRepository;

@Service
public class TurnOnSMS implements IntentExecutor {
	
	public static final Logger logger = Logger.getLogger(TurnOnSMS.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
		// TODO Auto-generated method stub
		return null;
	}

}
