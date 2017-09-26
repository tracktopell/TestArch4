package com.tracktopell.testarch4.restclient;

import com.tracktopell.testarch4.api.PersonService;
import com.tracktopell.testarch4.api.proxyclient.JacksonServiceProxy;
import com.tracktopell.testarch4.dto.Person;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alfredo.estrada
 */
public class PersonServiceClient extends JacksonServiceProxy implements PersonService{

	public PersonServiceClient(String serviceEndpointURL) {
		super(serviceEndpointURL);
	}
	
	@Override
	public List<Person> getAll() {
		List<Person> l = null;
		WebTarget target = client.target(serviceEndpointURL);
				
		String r = target.request(MediaType.APPLICATION_JSON).get(String.class);

		ObjectMapper mapper = new ObjectMapper();
		try{
			l = mapper.readValue(r, new TypeReference<List<Person>>(){});
		}catch(IOException ioe){
			ioe.printStackTrace(System.err);
		}

		return l;
	}
	
}
