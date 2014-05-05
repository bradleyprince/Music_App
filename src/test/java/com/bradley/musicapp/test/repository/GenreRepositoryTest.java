/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.repository;

import com.bradley.musicapp.app.conf.ConnectionConfig;
import com.bradley.musicapp.domain.Genre;
import com.bradley.musicapp.repository.GenreRepository;
import com.bradley.musicapp.repository.PersonRepository;
import static com.bradley.musicapp.test.repository.PersonRepositoryTest.ctx;
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
public class GenreRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private GenreRepository repo;
    
    public GenreRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void createGenre() {
        repo = ctx.getBean(GenreRepository.class);
        
        Genre genre = new Genre();
        genre.setType("Pop");
        
        repo.save(genre);
        id = genre.getId();
        
        Assert.assertNotNull(genre);
    }
    
    @Test(dependsOnMethods = "createGenre")
    public void readGenre(){        
        repo = ctx.getBean(GenreRepository.class);
        Genre genre = repo.findOne(id);
        Assert.assertEquals(genre.getType(), "Pop");
         
    }
    
    @Test(dependsOnMethods = "readGenre")
    private void updateGenre(){
        repo = ctx.getBean(GenreRepository.class);
        Genre genre = repo.findOne(id);
        Genre updateGenre = genre;
        updateGenre.setType("Reggae");
        
        repo.save(updateGenre);
         
        Genre newGenre = repo.findOne(id);
        Assert.assertEquals(newGenre.getType(), "Reggae");
         
    }
    @Test(dependsOnMethods = "updateGenre")
    private void deleteGenre(){
        repo = ctx.getBean(GenreRepository.class);
        Genre genre = repo.findOne(id);
        repo.delete(genre);
         
        Genre deleteGenre = repo.findOne(id);
         
        Assert.assertNull(deleteGenre);
    
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