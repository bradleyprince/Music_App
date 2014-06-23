/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.presentation;

import com.bradley.musicapp.domain.Name;
import com.bradley.musicapp.domain.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Balla
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    @ResponseBody
    public List<Person> getPersons(){
        List<Person> persons = new ArrayList<>();
        Name name = new Name();
        name.setFirstName("morris");
        
        Person p1 = new Person.Builder().name(name).build();
        
        Name name2 = new Name();
        name2.setFirstName("Adam");
        Person p2 = new Person.Builder().name(name2).build();
        
        Name name3 = new Name();
        name3.setFirstName("Luke");
        Person p3 = new Person.Builder().name(name3).build();
       
        persons.add(p3);
        persons.add(p1);
        persons.add(p2);
        
        return persons;
    }
}
