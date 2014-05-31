/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.repository;

import com.bradley.musicapp.app.conf.ConnectionConfig;
import com.bradley.musicapp.domain.Album;
import com.bradley.musicapp.repository.AlbumRepository;
import com.bradley.musicapp.repository.AlbumRepository;
import static com.bradley.musicapp.test.repository.AlbumRepositoryTest.ctx;
import java.math.BigDecimal;
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
public class AlbumRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private AlbumRepository repo;
    
    public AlbumRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createAlbum() {
        repo = ctx.getBean(AlbumRepository.class);
        
        Album album = new Album.Builder().albumName("SmallTalk").albumPrice(new BigDecimal("230.00")).build();

        repo.save(album);
        id = album.getId();
        
        Assert.assertNotNull(album);
    }
    
    @Test(dependsOnMethods = "createAlbum")
    public void readAlbum(){        
        repo = ctx.getBean(AlbumRepository.class);
        Album album = repo.findOne(id);
        Assert.assertEquals(album.getAlbumName(), "SmallTalk");
         
    }
    
    @Test(dependsOnMethods = "readAlbum")
    private void updateAlbum(){
        repo = ctx.getBean(AlbumRepository.class);
        Album album = repo.findOne(id);
        Album updateAlbum = new Album.Builder().album(album).albumName("BigTalk").build();
        
        repo.save(updateAlbum);
         
        Album newAlbum = repo.findOne(id);
        Assert.assertEquals(newAlbum.getAlbumName(), "BigTalk");
         
    }
    
    @Test(dependsOnMethods = "updateAlbum")
    private void deleteAlbum(){
        repo = ctx.getBean(AlbumRepository.class);
        Album album = repo.findOne(id);
        repo.delete(album);
         
        Album deleteAlbum = repo.findOne(id);
         
        Assert.assertNull(deleteAlbum); 
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