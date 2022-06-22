/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.service;

import co.com.data.dto.Person;
import java.util.List;

/**
 *
 * @author jpatarroyo
 */
public interface PersonService {

    public List<Person> getPeople();

    public Person getPerson(Person persona);

    public void addPerson(Person persona);

    public void updatePerson(Person persona);

    public void deletePerson(Person persona);

    public long countPeople();
}
