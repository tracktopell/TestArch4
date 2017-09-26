package com.tracktopell.testarch4.ws;

import com.tracktopell.testarch4.PersonDAOSessionBean;
import com.tracktopell.testarch4.dto.Person;
import com.tracktopell.testarch4.remote.PersonRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author alfredo.estrada
 */
@Stateless(name = "personServiceBean",mappedName = "personServiceBean",description = "person RS")
@Path("/person")
public class PersonServiceBean implements PersonRemote{

	@EJB PersonDAOSessionBean csb;
	
	@Path("/getAll")
	@GET
	@Produces("application/json")
	public List<Person> getAll(){
		return csb.getAllPersons();
	}
}
