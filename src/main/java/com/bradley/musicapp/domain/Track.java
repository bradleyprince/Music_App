/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Balla
 */
@Entity
public class Track implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String trackName;
    private String trackLength;

    private Track(Builder builder){
        id = builder.id;
        trackName = builder.trackName;
        trackLength = builder.trackLength;
    }
    
    private Track(){
    }
    
    public static class Builder{
        private Long id;
        private String trackName;
        private String trackLength;
        
        public Builder(){           
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder trackName(String value){
            this.trackName = value;
            return this;
        }
        
        public Builder trackLength(String value){
            this.trackLength = value;
            return this;
        }
        
        public Builder track(Track track){
            id = track.getId();
            trackName = track.getTrackName();
            trackLength = track.getTrackLength();
            
            return this;
        }   
        
        public Track build(){
            return new Track(this);
        }
    }
    
    public String getTrackName() {
        return trackName;
    }

    public String getTrackLength() {
        return trackLength;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.musicapp.domain.Track[ id=" + id + " ]";
    }
    
}
