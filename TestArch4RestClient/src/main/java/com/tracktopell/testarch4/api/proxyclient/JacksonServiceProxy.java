package com.tracktopell.testarch4.api.proxyclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author alfredo.estrada
 */
public class JacksonServiceProxy {
	protected ObjectMapper mapper = new ObjectMapper();
	protected String serviceEndpointURL = null;
	protected Client client = ClientBuilder.newClient();
	
	public JacksonServiceProxy(String serviceEndpointURL){
		this.mapper				= new ObjectMapper();
		this.serviceEndpointURL = serviceEndpointURL;	
	}
	
}
