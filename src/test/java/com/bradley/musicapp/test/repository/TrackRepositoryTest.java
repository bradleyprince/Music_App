/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.repository;

import com.bradley.musicapp.domain.Track;
import com.bradley.musicapp.repository.TrackRepository;
import com.bradley.musicapp.test.ConnectionConfigTest;
import static com.bradley.musicapp.test.repository.TrackRepositoryTest.ctx;
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
 * @author Balla
 */
public class TrackRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    
    private TrackRepository repo;
    
    public TrackRepositoryTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void createTrack() {
        repo = ctx.getBean(TrackRepository.class);
        
        Track track = new Track.Builder().trackName("SistaBatina").trackLength("2:45").build();     

        repo.save(track);
        id = track.getId();
        
        Assert.assertNotNull(track);
    }
    
    @Test(dependsOnMethods = "createTrack")
    public void readTrack(){        
        repo = ctx.getBean(TrackRepository.class);
        Track track = repo.findOne(id);
        Assert.assertEquals(track.getTrackName(), "SistaBatina");
         
    }
    
    @Test(dependsOnMethods = "readTrack")
    private void updateTrack(){
        repo = ctx.getBean(TrackRepository.class);
        Track track = repo.findOne(id);
        Track updateTrack = new Track.Builder().track(track).trackName("Ngomso").build();
        
        repo.save(updateTrack);
         
        Track newTrack = repo.findOne(id);
        Assert.assertEquals(newTrack.getTrackName(), "Ngomso");
         
    }
    
    @Test(dependsOnMethods = "updateTrack")
    private void deleteTrack(){
        repo = ctx.getBean(TrackRepository.class);
        Track track = repo.findOne(id);
        repo.delete(track);
         
        Track deleteTrack = repo.findOne(id);
         
        Assert.assertNull(deleteTrack); 
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