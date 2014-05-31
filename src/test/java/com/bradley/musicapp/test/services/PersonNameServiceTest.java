/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.services;

import com.bradley.musicapp.app.conf.ConnectionConfig;
import com.bradley.musicapp.domain.Person;
import com.bradley.musicapp.repository.PersonRepository;
import com.bradley.musicapp.sevices.PersonNameService;
import static com.bradley.musicapp.test.repository.PersonRepositoryTest.ctx;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Balla
 */
public class PersonNameServiceTest {
    public static ApplicationContext ctx;
    private Long id;
    private PersonRepository personRepository;
    private PersonNameService personService;
    
    public PersonNameServiceTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getPeopleNameStartingWith() {
        personRepository = ctx.getBean(PersonRepository.class);
        personService = ctx.getBean(PersonNameService.class);
        
        Person p1 = new Person.Builder().name("Chris").build();
        
        Person p2 = new Person.Builder().name("Cobra").build();
        
        Person p3 = new Person.Builder().name("Copper").build();
        
        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
        
        List<Person> people = personService.getNamesStartingWith("C");

        Assert.assertEquals(people.size(), 3);
        
        personRepository.delete(p1);
        personRepository.delete(p2);
        personRepository.delete(p3);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}