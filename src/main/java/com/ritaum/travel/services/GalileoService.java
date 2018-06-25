package com.ritaum.travel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ritaum.travel.galileo.xmlselect.BeginSessionResponse;
import com.ritaum.travel.galileo.xmlselect.client.GalileoBeginSessionClient;
import com.ritaum.travel.galileo.xmlselect.client.GalileoEndSessionClient;

@Service
public class GalileoService {

	public static final Logger logger = LoggerFactory.getLogger(GalileoService.class);

	@Autowired
	private GalileoBeginSessionClient beginSessionClient;
	
	@Autowired
	private GalileoEndSessionClient endSessionClient;
	
	public void getAvailability() {
		
		BeginSessionResponse beginSession = beginSessionClient.beginSession("");
		logger.info("Got begin session response: " + beginSession.getBeginSessionResult());

		logger.info("Getting available flights...");
		
		logger.info("Ending session now...");
		endSessionClient.endSession("");
	}

}
