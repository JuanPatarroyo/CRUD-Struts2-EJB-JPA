/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.interfaces;

import co.com.data.dto.Person;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public interface PersonDao {

    void insertPerson(Person person);

    void updatePerson(Person person);

    void deletePerson(Person person);

    Person findPersonById(long personId);

    List<Person> findPeople();

    long countPeople();

    Person getPersonByEmail(Person person);
    
}
