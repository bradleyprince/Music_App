/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Balla
 */
@Entity
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String artistName;
    private Integer artistAge;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="artist_id")
    List<Album> albumList;
    
    private Artist(Builder builder){
        id = builder.id;
        artistName = builder.artistName;
        artistAge = builder.artistAge;
        albumList = builder.albumList;      
    }
    
    private Artist(){    
    }

    public static class Builder{
        private Long id;
        private String artistName;
        private Integer artistAge;
        List<Album> albumList;
        
        public Builder(){           
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder artistName(String value){
            this.artistName = value;
            return this;
        }
        
        public Builder artistAge(Integer value){
            this.artistAge = value;
            return this;
        }
        
        public Builder albumList(List<Album> value){
            this.albumList = value;
            return this;
        }
        
        public Builder artist(Artist artist){
            id = artist.getId();
            artistName = artist.getArtistName();
            artistAge = artist.getArtistAge();
            albumList = artist.getAlbumList();
            return this;
        }
        
        public Artist build(){
            return new Artist(this);
        }
    }
    
    public String getArtistName() {
        return artistName;
    }

    public Integer getArtistAge() {
        return artistAge;
    }
    
    public List<Album> getAlbumList() {
        return albumList;
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
        if (!(object instanceof Artist)) {
            return false;
        }
        Artist other = (Artist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.musicapp.domain.Artist[ id=" + id + " ]";
    }
    
}
