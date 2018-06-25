
package com.ritaum.travel.galileo.xmlselect.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class GalileoConfiguration {

	@Value("${galileo.ws.endpoint}")
	private String wsEndpoint;

	@Value("${galileo.ws.username}")
	private String wsUsername;

	@Value("${galileo.ws.password}")
	private String wsPassword;

	@Value("${galileo.ws.hap}")
	private String wsHap;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.ritaum.travel.galileo.xmlselect");
		return marshaller;
	}

	@Bean
	public GalileoBeginSessionClient beginSessionClient(Jaxb2Marshaller marshaller) {
		GalileoBeginSessionClient client = new GalileoBeginSessionClient(wsEndpoint, wsUsername, wsPassword, wsHap);
		client.setDefaultUri(wsEndpoint);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

	@Bean
	public GalileoEndSessionClient endSessionClient(Jaxb2Marshaller marshaller) {
		GalileoEndSessionClient client = new GalileoEndSessionClient();
		client.setDefaultUri(wsEndpoint);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
