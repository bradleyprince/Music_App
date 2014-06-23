/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.sevices.impl;

import com.bradley.musicapp.domain.Track;
import com.bradley.musicapp.repository.TrackRepository;
import com.bradley.musicapp.sevices.TrackFindService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Balla
 */
@Service
public class TrackFindServiceImpl implements TrackFindService{

    @Autowired TrackRepository repository;
    
    @Override
    public Track getTrackName(String trackName) {
        List<Track> trackList = findAll();
        Track mainTrack = null;
        
        for(Track track : trackList){
            if(track.getTrackName().equals(trackName)){
                mainTrack = track;
            }
        }
        
        return mainTrack;
    }

    @Override
    public Track find(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Track persist(Track entity) {
        return repository.save(entity);
    }

    @Override
    public Track merge(Track entity) {
        if(entity.getId() != null){
            return repository.save(entity);
        }
        
        return null;
                    
    }

    @Override
    public void remove(Track entity) {
        repository.delete(entity);
    }

    @Override
    public List<Track> findAll() {
        return repository.findAll();
    }
    
}
