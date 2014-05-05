/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.repository;

import com.bradley.musicapp.app.conf.ConnectionConfig;
import com.bradley.musicapp.domain.Artist;
import com.bradley.musicapp.domain.Genre;
import com.bradley.musicapp.repository.ArtistRepository;
import com.bradley.musicapp.repository.GenreRepository;
import static com.bradley.musicapp.test.repository.GenreRepositoryTest.ctx;
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
public class ArtistRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private ArtistRepository repo;
    
    public ArtistRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createArtist() {
        repo = ctx.getBean(ArtistRepository.class);
        
        Artist artist = new Artist();
        artist.setArtistAge(23);
        artist.setArtistName("Bradley");

        repo.save(artist);
        id = artist.getId();
        
        Assert.assertNotNull(artist);
    }
    
    @Test(dependsOnMethods = "createArtist")
    public void readArtist(){        
        repo = ctx.getBean(ArtistRepository.class);
        Artist artist = repo.findOne(id);
        Assert.assertEquals(artist.getArtistName(), "Bradley");
         
    }
    
    @Test(dependsOnMethods = "readArtist")
    private void updateArtist(){
        repo = ctx.getBean(ArtistRepository.class);
        Artist artist = repo.findOne(id);
        Artist updateArtist = artist;
        updateArtist.setArtistName("John");
        
        repo.save(updateArtist);
         
        Artist newArtist = repo.findOne(id);
        Assert.assertEquals(newArtist.getArtistName(), "John");
         
    }
    @Test(dependsOnMethods = "updateArtist")
    private void deleteArtist(){
        repo = ctx.getBean(ArtistRepository.class);
        Artist artist = repo.findOne(id);
        repo.delete(artist);
         
        Artist deleteArtist = repo.findOne(id);
         
        Assert.assertNull(deleteArtist);
    
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