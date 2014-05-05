/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.repository;

import com.bradley.musicapp.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Balla
 */
@Repository("personRepository")
@Transactional
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
