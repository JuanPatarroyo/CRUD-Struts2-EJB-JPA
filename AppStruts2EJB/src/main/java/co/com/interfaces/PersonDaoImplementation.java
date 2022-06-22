/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.interfaces;

import co.com.data.dto.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Stateless
public class PersonDaoImplementation implements PersonDao {

    Logger log = LogManager.getRootLogger();

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertPerson(Person persona) {
        // Insertamos nuevo objeto
        em.persist(persona);
    }

    @Override
    public void updatePerson(Person persona) {
        // Actualizamos al objeto 
        em.merge(persona);
    }

    @Override
    public void deletePerson(Person persona) {
         em.remove(em.merge(persona));
    }

    @Override
    public Person findPersonById(long idPerson) {
        return em.find(Person.class, idPerson);
    }

    @Override
    public List<Person> findPeople() {
        String jpql = "SELECT p FROM Person p";
        Query query = em.createQuery(jpql);
        //Forzar a ir directamente a la base de datos para refrescar datos
        query.setHint("javax.persistence.cache.storeMode", CacheStoreMode.REFRESH);
        List<Person> personas = query.getResultList();
        System.out.println("personas:" + personas);
        return personas;
    }

    @Override
    public long countPeople() {
        String consulta = "select count(p) from Person p";
        Query q = em.createQuery(consulta);
        long contador = (long) q.getSingleResult();
        return contador;
    }

    @Override
    public Person getPersonByEmail(Person persona) {
        String cadena = "%" + persona.getEmail() + "%"; //se usa en el like como caracteres especiales
        String consulta = "from Person p where upper(p.email) like upper(:param1)";
        Query q = em.createQuery(consulta);
        q.setParameter("param1", cadena);
        return (Person) q.getSingleResult();
    }
}