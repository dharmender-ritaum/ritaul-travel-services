
package com.ritaum.travel.galileo.xmlselect.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.ritaum.travel.galileo.xmlselect.EndSession;
import com.ritaum.travel.galileo.xmlselect.EndSessionResponse;

public class GalileoEndSessionClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(GalileoEndSessionClient.class);

	public EndSessionResponse endSession(String token) {

		EndSession request = new EndSession();
		request.setToken(token);

		log.info("Requesting quote for " + token);

		EndSessionResponse response = (EndSessionResponse) getWebServiceTemplate().marshalSendAndReceive(
				"https://apac.copy-webservices.travelport.com/B2BGateway/service/XMLSelect", request,
				new SoapActionCallback("https://webservices.galileo.com/EndSession"));

		return response;
	}

}
