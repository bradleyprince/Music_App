package com.bradley.musicapp.test.repository;

import java.math.BigDecimal;

import com.bradley.musicapp.domain.Album;
import com.bradley.musicapp.repository.AlbumRepository;
import com.bradley.musicapp.test.ConnectionConfigTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Bradley Prince
 */
public class AlbumRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private AlbumRepository repo;
    
    public AlbumRepositoryTest() {
    }
    
    @Test
    public void createAlbum() {
        this.repo = ctx.getBean(AlbumRepository.class);
        
        Album album = new Album.Builder().albumName("SmallTalk").albumPrice(new BigDecimal("230.00")).build();

        this.repo.save(album);
        this.id = album.getId();
        
        Assert.assertNotNull(album);
    }
    
    @Test(dependsOnMethods = "createAlbum")
    public void readAlbum(){
        this.repo = ctx.getBean(AlbumRepository.class);
        Album album = this.repo.findOne(this.id);
        Assert.assertEquals(album.getAlbumName(), "SmallTalk");
         
    }
    
    @Test(dependsOnMethods = "readAlbum")
    private void updateAlbum(){
        this.repo = ctx.getBean(AlbumRepository.class);
        Album album = this.repo.findOne(this.id);
        Album updateAlbum = new Album.Builder().album(album).albumName("BigTalk").build();
        
        this.repo.save(updateAlbum);
         
        Album newAlbum = this.repo.findOne(this.id);
        Assert.assertEquals(newAlbum.getAlbumName(), "BigTalk");
         
    }
    
    @Test(dependsOnMethods = "updateAlbum")
    private void deleteAlbum(){
        this.repo = ctx.getBean(AlbumRepository.class);
        Album album = this.repo.findOne(this.id);
        this.repo.delete(album);
         
        Album deleteAlbum = this.repo.findOne(this.id);
         
        Assert.assertNull(deleteAlbum);
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
    }
}