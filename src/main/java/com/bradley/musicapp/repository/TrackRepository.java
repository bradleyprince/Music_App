/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.repository;

import com.bradley.musicapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Balla
 */
public interface TrackRepository extends JpaRepository<Track, Long>{
    
}
