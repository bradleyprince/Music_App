/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bradley.musicapp.presentation.rest;

import com.bradley.musicapp.domain.Person;
import com.bradley.musicapp.sevices.PersonNameService;
import com.bradley.musicapp.sevices.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bradley
 */
@Controller
@RequestMapping(value = "api/person")
public class PersonRestController {
    @Autowired PersonService personService;
    @Autowired PersonNameService personNameService;
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody Person person) {
        personService.persist(person);
        
        System.out.println(" Create the Called ");
        return "Person Created";
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Person person) {
        personService.merge(person);
        
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "person/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable Long id) {
        
        System.out.println(" ID called ");
        return personService.find(id);
    }

    @RequestMapping(value = "persons", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersons() {
        System.out.println("The PERSON");
        return personService.findAll();
    }

    @RequestMapping(value = "person/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Person getPersonName(@PathVariable String name) {
        System.out.println("The Person name");
        return personNameService.getPersonByName(name);
    }

}
