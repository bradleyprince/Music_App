/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.repository;

import com.bradley.musicapp.app.conf.ConnectionConfig;
import com.bradley.musicapp.domain.Person;
import com.bradley.musicapp.repository.PersonRepository;
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
public class PersonRepositoryTest {    
    public static ApplicationContext ctx;
    private Long id;
    
    private PersonRepository repo;
    
    public PersonRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createPerson() {
        repo = (PersonRepository)ctx.getBean("personRepository");
        
        Person person = new Person();
        person.setName("Bradley");
        
        repo.save(person);
        id = person.getId();
        Assert.assertNotNull(person);
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