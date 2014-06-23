/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.services;

import com.bradley.musicapp.domain.Track;
import com.bradley.musicapp.sevices.TrackFindService;
import com.bradley.musicapp.sevices.impl.TrackFindServiceImpl;
import com.bradley.musicapp.test.ConnectionConfigTest;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TrackFindServiceTest {
    public static ApplicationContext ctx;
    @Autowired TrackFindService findService;
    
    public TrackFindServiceTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getTrack() {
        findService = ctx.getBean(TrackFindService.class);
        
        Track track = new Track.Builder().trackName("Stand").trackLength("01:56").build();
        findService.persist(track);
        
        Track foundTrack = findService.getTrackName("Stand");
        //System.out.println("Saved Track = ");
        
        Assert.assertEquals(track.getTrackName(),foundTrack.getTrackName());
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