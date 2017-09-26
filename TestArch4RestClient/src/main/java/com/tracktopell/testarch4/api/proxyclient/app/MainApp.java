package com.tracktopell.testarch4.api.proxyclient.app;

import com.tracktopell.testarch4.dto.Person;
import com.tracktopell.testarch4.restclient.PersonServiceClient;
import java.util.List;

/**
 *
 * @author alfredo.estrada
 */
public class MainApp {
	private static PersonServiceClient personServiceClient;
	
	public static void main(String[] args) {
		personServiceClient = new PersonServiceClient ("http://localhost:8080/TestArch4BackEnd-ws/restapi/person/getAll");
		List<Person> personList = personServiceClient.getAll();
		
		for(Person p: personList){
			System.err.println("->p:"+p);
		}
		
	}
}
