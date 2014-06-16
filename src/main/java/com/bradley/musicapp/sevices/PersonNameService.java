/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.sevices;

import com.bradley.musicapp.domain.Person;
import java.util.List;

/**
 *
 * @author Balla
 */
public interface PersonNameService extends Services<Person, Long>{
    public List<Person> getNamesStartingWith(String startingWith);
}
