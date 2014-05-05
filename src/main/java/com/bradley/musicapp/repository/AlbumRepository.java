/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.repository;

import com.bradley.musicapp.domain.Album;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Balla
 */
public interface AlbumRepository extends JpaRepository<Album, Long>{
    
}
