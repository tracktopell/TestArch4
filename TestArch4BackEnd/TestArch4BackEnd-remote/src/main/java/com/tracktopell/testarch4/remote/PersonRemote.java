package com.tracktopell.testarch4.remote;

/**
 *
 * @author alfredo.estrada
 */
import com.tracktopell.testarch4.api.PersonService;
import com.tracktopell.testarch4.dto.Person;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface PersonRemote extends PersonService {
}
