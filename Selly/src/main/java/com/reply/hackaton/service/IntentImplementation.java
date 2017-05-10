package com.reply.hackaton.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reply.hackaton.repository.PersonalInfoRepository;
import com.reply.hackaton.repository.TransactionHistoryRepository;
import com.reply.hackaton.repository.UserRepository;

@Service
public class IntentImplementation {

	public static final Logger logger = Logger.getLogger(IntentImplementation.class);
	
	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;
	@Autowired
	private PersonalInfoRepository personalInfoRepository;
	@Autowired
	private UserRepository userRepository;

	public boolean turnOffSMS() {
		return false;
	}

	public boolean turnOnSMS() {
		return true;
	}

}
