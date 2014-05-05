/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.sevices.impl;

import com.bradley.musicapp.domain.Person;
import com.bradley.musicapp.repository.PersonRepository;
import com.bradley.musicapp.sevices.PersonNameService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */
@Service
public class PersonNameServiceImpl implements PersonNameService{
    
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getNamesStartingWith(String startingWith) {
        List<Person> personList = personRepository.findAll();
        List<Person> personsStartingWithList = new LinkedList<Person>();
        
        for(Person person : personList){
            if(person.getName().startsWith(startingWith)){
                personsStartingWithList.add(person);
            }
        }
        
        return personsStartingWithList;
    }
    
}
