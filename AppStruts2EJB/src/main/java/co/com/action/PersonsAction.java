/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.action;

import co.com.data.dto.Person;
import co.com.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author jpatarroyo
 */
public class PersonsAction extends ActionSupport {

    private List<Person> people;

    private Person person;

    @Inject
    private PersonService personService;

    Logger log = LogManager.getLogger(PersonsAction.class);

    @Action(value = "/list", results = {
        @Result(name = "people", location = "/WEB-INF/content/person.jsp")})
    public String listar() {
        this.people = personService.getPeople();
        return "people";
    }

    @Action(value = "/addPerson", results = {
        @Result(name = "person", location = "/WEB-INF/content/personActions.jsp")})
    public String agregar() {
        //Creamos un nuevo objeto de tipo persona
        person = new Person();
        return "person";
    }

    @Action(value = "/updatePerson", results = {
        @Result(name = "person", location = "/WEB-INF/content/personActions.jsp")})
    public String editar() {
        person = personService.getPerson(person);
        return "person";
    }

    @Action(value = "/deletePerson", results = {
        @Result(name = "success", location = "list", type = "redirect")})
    public String eliminar() {
        //Recuperamos el objeto persona, ya que solo tenemos el idPerson
        log.info("Metodo eliminar persona antes de recuperar:" + person);
        person = personService.getPerson(person); //revisar si se puede quitar el == y sigue funcionando, por referencia
        log.info("Metodo eliminar persona despues de recuperar:" + person);
        personService.deletePerson(person);
        return SUCCESS;
    }

    //No basta con mandar al JSP, sino a la accion de listar
    //por ello redireccionamos a la accion listar
    @Action(value = "/savePerson", results = {
        @Result(name = "success", location = "list", type = "redirect")})
    public String guardar() {
        //Diferenciamos la accion de agregar o editar con el idPerson
        if (person.getId() == null) {
            personService.addPerson(person);
        } else {
            personService.updatePerson(person);
        }
        return SUCCESS;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
}
