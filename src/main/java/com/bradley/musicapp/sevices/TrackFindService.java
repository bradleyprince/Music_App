/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.sevices;

import com.bradley.musicapp.domain.Track;

/**
 *
 * @author Balla
 */
public interface TrackFindService extends Services<Track, Long>{
    public Track getTrackName(String trackName);
}
