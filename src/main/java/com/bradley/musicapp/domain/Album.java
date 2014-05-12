/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Balla
 */
@Entity
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String albumName;
    private BigDecimal albumPrice;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")        
    List<Track> trackList;
    @OneToOne
    @JoinColumn(name = "album_id")
    private Genre genre;
    

    private Album(Builder builder) {
        id = builder.id;
        albumName = builder.albumName;
        albumPrice = builder.albumPrice;
        trackList = builder.trackList;
        genre = builder.genre;
        
    }
    
    private Album(){
    }
    
    public static class Builder{
        private Long id;
        private String albumName;
        private BigDecimal albumPrice;
        List<Track> trackList;
        private Genre genre;
        
        public Builder(){           
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder albumName(String value){
            this.albumName = value;
            return this;
        }
        
        public Builder albumPrice(BigDecimal value){
            this.albumPrice = value;
            return this;
        }
        
        public Builder trackList(List<Track> value){
            this.trackList = value;
            return this;
        }
        
        public Builder genre(Genre value){
            this.genre = value;
            return this;
        }
        
        public Builder album(Album album){
            id = album.getId();
            albumName = album.getAlbumName();
            albumPrice = album.getAlbumPrice();
            trackList = album.getTrackList();
            genre = album.getGenre();
            
            return this;
        }
        public Album build(){
            return new Album(this);
        }
    }
    
    public Genre getGenre() {
        return genre;
    }

    public String getAlbumName() {
        return albumName;
    }

    public BigDecimal getAlbumPrice() {
        return albumPrice;
    }

    public List<Track> getTrackList() {
        return trackList;
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
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.musicapp.domain.Album[ id=" + id + " ]";
    }
    
}
