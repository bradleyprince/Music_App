/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.sevices.impl;

import com.bradley.musicapp.domain.Person;
import com.bradley.musicapp.repository.PersonRepository;
import com.bradley.musicapp.sevices.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired PersonRepository personRepository; 
    
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
        }else{
            return null;
        }
        
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
