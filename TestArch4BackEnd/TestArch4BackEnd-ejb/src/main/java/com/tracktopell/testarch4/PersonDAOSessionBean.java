/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tracktopell.testarch4;

import com.tracktopell.testarch4.dto.Address;
import com.tracktopell.testarch4.dto.Person;
import com.tracktopell.testarch4.dto.PhoneNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 * @author alfredo.estrada
 */
@Stateless(name = "PersonDAOSessionBean",mappedName = "PersonDAOSessionBean", description = "PersonDAO Session Bean")
@LocalBean
public class PersonDAOSessionBean {
	private static HashMap<Integer,Person> persons;
	private static final int N_PERSONS = 5;
	private static HashMap<Integer, Person> getPersons() {
		if(persons ==null){
			persons = new HashMap<Integer, Person> ();
			int ib=(int)System.currentTimeMillis();
			for(int i=0; i<N_PERSONS; i++){
				Person x = new Person(
						"NOMBRE["+i+"]", "APELLIDO["+i+"]", 
						new Address("DIRECCION["+i+"]","CIUDAD["+i+"]","ESTADO["+i+"]"), 
						Arrays.asList(new PhoneNumber[]{
								new PhoneNumber("M", "0012345"+i),
								new PhoneNumber("H", "9912345"+i)
							}
						));	
				
				x.setId(ib+i);
				
				persons.put(x.getId(), x);
			}			
		}
		return persons;
	}
	
	
    public List<Person> getAllPersons() {
		HashMap<Integer, Person> thePersons = getPersons();
		List<Person> personList = new ArrayList<>();
		
		personList.addAll(thePersons.values());
		
		return personList;
    }
}
