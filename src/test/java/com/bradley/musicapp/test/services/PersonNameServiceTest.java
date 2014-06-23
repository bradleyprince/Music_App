/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.services;

import com.bradley.musicapp.app.conf.ConnectionConfig;
import com.bradley.musicapp.domain.Name;
import com.bradley.musicapp.domain.Person;
import com.bradley.musicapp.repository.PersonRepository;
import com.bradley.musicapp.sevices.PersonNameService;
import com.bradley.musicapp.test.ConnectionConfigTest;
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
    private PersonNameService personService;
    
    public PersonNameServiceTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getPeopleNameStartingWith() {
        personService = ctx.getBean(PersonNameService.class);
        Name name = new Name();
        name.setFirstName("Chris");
        
        Person p1 = new Person.Builder().name(name).build();
        
        Name name1 = new Name();
        name1.setFirstName("Cobra");
        
        Person p2 = new Person.Builder().name(name1).build();
        
        Name name2 = new Name();
        name2.setFirstName("Copper");
        
        Person p3 = new Person.Builder().name(name2).build();
        
        personService.persist(p1);
        personService.persist(p2);
        personService.persist(p3);
        
        List<Person> people = personService.getNamesStartingWith("C");

        Assert.assertEquals(people.size(), 3);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        personService = ctx.getBean(PersonNameService.class);
        List<Person> list = personService.findAll();
        
        for(Person person : list){
            personService.remove(person);
        }
    }
}