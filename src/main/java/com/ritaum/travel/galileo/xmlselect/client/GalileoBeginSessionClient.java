
package com.ritaum.travel.galileo.xmlselect.client;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.ritaum.travel.galileo.xmlselect.BeginSession;
import com.ritaum.travel.galileo.xmlselect.BeginSessionResponse;

public class GalileoBeginSessionClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(GalileoBeginSessionClient.class);
	private String wsEndpoint;
	private String wsUsername;
	private String wsPassword;
	private String wsHap;

	public GalileoBeginSessionClient() {

	}

	public GalileoBeginSessionClient(String wsEndpoint, String wsUsername, String wsPassword, String wsHap) {
		this.wsEndpoint = wsEndpoint;
		this.wsUsername = wsUsername;
		this.wsPassword = wsPassword;
		this.wsHap = wsHap;
	}

	public BeginSessionResponse beginSession(String ticker) {

		BeginSession request = new BeginSession();
		request.setProfile(this.wsHap);

		log.info("Requesting Galileo begin session for " + ticker);

		WebServiceTemplate serviceTemplate = getWebServiceTemplate();
		serviceTemplate.setMessageSender(defaultMwMessageSender());
		BeginSessionResponse response = (BeginSessionResponse) serviceTemplate.marshalSendAndReceive(this.wsEndpoint,
				request, new SoapActionCallback("https://webservices.galileo.com/BeginSession"));

		return response;
	}

	public HttpComponentsMessageSender defaultMwMessageSender() {
		HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();
		messageSender.setCredentials(new UsernamePasswordCredentials(this.wsUsername, this.wsPassword));
		return messageSender;
	}

}
