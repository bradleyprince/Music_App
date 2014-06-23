/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.presentation.rest;

import com.bradley.musicapp.domain.Track;
import com.bradley.musicapp.sevices.TrackFindService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bradley
 */
@Controller  // Annotation to make this class be detectable by the config as a controller
@RequestMapping(value = "api/track") // This the url e.g http://localhost:8084/askweb/api/track
public class TrackRestController {
    @Autowired
    private TrackFindService trackService;
    

    @RequestMapping(value = "create",method = RequestMethod.POST, consumes = "application/json") // This the uri e.g http://localhost:8084/askweb/api/track/create
    @ResponseBody //Converts output or response to JSON String
    public Track create(@RequestBody Track track) { // @RequestBody for converting incoming JSON call to Object
        trackService.persist(track);
        
        System.out.println(" Create the Called ");
        return track;
    }

    @RequestMapping(value = "update",method = RequestMethod.PUT) //This the uri e.g http://localhost:8084/askweb/api/track/update
    @ResponseBody
    public Track update(@RequestBody Track track) {
        trackService.merge(track);
        System.out.println(" Update Called ");
        return track;
    }

    @RequestMapping(value = "id/{id}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/track/1234
    @ResponseBody
    public Track getTrack(@PathVariable Long id) { //@PathVariable used to bind the id value
        
        System.out.println(" ID called ");
        return trackService.find(id);
    }

    @RequestMapping(value = "tracks",method = RequestMethod.GET) // Always Put HTTP Method
    @ResponseBody
    public List<Track> getTracks() {
        System.out.println("The Tracks");
        return trackService.findAll();
    }

    @RequestMapping(value = "name/{name}",method = RequestMethod.GET) //http://localhost:8084/askweb/api/track/yolo
    @ResponseBody
    public Track getTrackByName(@PathVariable String name) {
        Track track = trackService.getTrackName(name); // Call the Service;
        System.out.println("Track = " + track);
        
        if(track != null){
            return track;
        }
        
        return null;
    }

}
