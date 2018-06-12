/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.test.restapi;

import java.util.Collections;

import com.bradley.musicapp.domain.Track;
import com.bradley.musicapp.sevices.TrackFindService;
import com.bradley.musicapp.test.ConnectionConfigTest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author bradley
 */
public class TrackRestControllerTest {

    private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8085/musicapp/";
    private static Long id;
    private static ApplicationContext ctx;
    @Autowired TrackFindService trackService;
    
    @Test
    public void testCreate() {
        Track track = new Track.Builder().trackName("yolo").trackLength("03:45").build();
        HttpEntity<Track> requestEntity = new HttpEntity<>(track, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<Track> responseEntity = this.restTemplate.
                exchange(URL + "api/track/create", HttpMethod.POST, requestEntity, Track.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        System.out.println("id = " + responseEntity.getBody().getId());
        id = responseEntity.getBody().getId();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

   @Test
    public void testTrackUpdate() {
       ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
       this.trackService = ctx.getBean(TrackFindService.class);
        // LEFT AS AN EXERCISE FOR YOU
        // GET THE TRACK and THEN CHANGE AND MAKE A COPY
        //THEN SEND TO THE SERVER USING A PUT OR POST
        // THEN READ BACK TO SEE IF YOUR CHANGE HAS HAPPENED
       System.out.println("id = " + id);
       System.out.println("track = " + this.trackService);
        Track foundTrack = this.trackService.find(id);
        Track track = new Track.Builder().track(foundTrack).trackName("lollipop").trackLength("02:22").build();
        
        HttpEntity<Track> requestEntity = new HttpEntity<>(track, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = this.restTemplate.
                exchange(URL + "api/track/update", HttpMethod.PUT, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
        
        Track foundTrack1 = this.trackService.find(id);
        System.out.println("updated track = " + track + " | original track = " + foundTrack1);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    public void testreadTrackByNameName() {
        String trackName = "yolo";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Track> responseEntity = this.restTemplate.exchange(URL + "api/track/name/" + trackName, HttpMethod.GET, requestEntity, Track.class);
        Track track = responseEntity.getBody();

        Assert.assertNotNull(track);

    }

    //@Test
    public void testreadTrackById() {
        String trackId = "2";
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Track> responseEntity = this.restTemplate.exchange(URL + "api/track/id/" + trackId, HttpMethod.GET, requestEntity, Track.class);
        Track track = responseEntity.getBody();

        Assert.assertNotNull(track);

    }

    //@Test
    public void testgetAllTracks() {
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Track[]> responseEntity = this.restTemplate.exchange(URL + "api/track/tracks", HttpMethod.GET, requestEntity, Track[].class);
        Track[] tracks = responseEntity.getBody();
        for (Track track : tracks) {
            System.out.println("The Track Name is " + track.getTrackName());

        }

        Assert.assertTrue(tracks.length > 0);
    }

    private HttpEntity<?> getHttpEntity() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        this.restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }

    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }

}
