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
        List<Person> personsStartingWithList = new LinkedList<>();
        
        for(Person person : personList){
            System.out.println("Starting With = " + startingWith);
            if(person.getName().getFirstName().startsWith(startingWith)){
                personsStartingWithList.add(person);
            }
        }
        
        return personsStartingWithList;
    }

    @Override
    public Person getPersonByName(String name) {
        List<Person> personList = personRepository.findAll();
        Person foundPerson = null;
        
        for(Person person : personList){
            if(person.getName().getFirstName().equalsIgnoreCase(name)){
                foundPerson = person;
                break;
            }
        }
        
        return foundPerson;
    }
    
    @Override
    public Person find(Long id) {
        return personRepository.findOne(id);
    }

    
    @Override
    public Person persist(Person entity) {
        return personRepository.save(entity);
    }

    
    @Override
    public Person merge(Person entity) {
        if(entity.getId() != null){
            return personRepository.save(entity);
        }
        
        return null;
    }

    
    @Override
    public void remove(Person entity) {
        personRepository.delete(entity);
    }

    
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

}
