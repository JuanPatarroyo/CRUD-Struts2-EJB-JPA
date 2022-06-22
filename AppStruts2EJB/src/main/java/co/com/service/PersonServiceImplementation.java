/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.service;

import co.com.data.dto.Person;
import co.com.interfaces.PersonDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jpatarroyo
 */
@Stateless
public class PersonServiceImplementation implements PersonService {

    @Inject
    private PersonDao personDao;

    @Override
    public List<Person> getPeople() {
        return personDao.findPeople();
    }

    @Override
    public Person getPerson(Person persona) {
        return personDao.findPersonById(persona.getId());
    }

    @Override
    public void addPerson(Person persona) {
        personDao.insertPerson(persona);
    }

    @Override
    public void updatePerson(Person persona) {
        personDao.updatePerson(persona);
    }

    @Override
    public void deletePerson(Person persona) {
        personDao.deletePerson(persona);
    }

    @Override
    public long countPeople() {
        return personDao.countPeople();
    }
    
}
