package com.bradley.musicapp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Date 2018-06-12
 *
 * @author BP
 */
@Entity
public class Album implements Serializable {
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String albumName;
   private BigDecimal albumPrice;
   @OneToMany
   @JoinColumn(name = "album_id")
   List<Track> trackList;
   @OneToOne
   @JoinColumn(name = "album_id")
   private Genre genre;
   
   
   private Album(final Builder builder) {
      this.id = builder.id;
      this.albumName = builder.albumName;
      this.albumPrice = builder.albumPrice;
      this.trackList = builder.trackList;
      this.genre = builder.genre;
      
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
      
      public Builder id(final Long value){
         this.id = value;
         return this;
      }
      
      public Builder albumName(final String value){
         this.albumName = value;
         return this;
      }
      
      public Builder albumPrice(final BigDecimal value){
         this.albumPrice = value;
         return this;
      }
      
      public Builder trackList(final List<Track> value){
         this.trackList = value;
         return this;
      }
      
      public Builder genre(final Genre value){
         this.genre = value;
         return this;
      }
      
      public Builder album(final Album album){
         this.id = album.getId();
         this.albumName = album.getAlbumName();
         this.albumPrice = album.getAlbumPrice();
         this.trackList = album.getTrackList();
         this.genre = album.getGenre();
         
         return this;
      }
      
      public Album build(){
         return new Album(this);
      }
   }
   
   public Genre getGenre() {
      return this.genre;
   }
   
   public String getAlbumName() {
      return this.albumName;
   }
   
   public BigDecimal getAlbumPrice() {
      return this.albumPrice;
   }
   
   public List<Track> getTrackList() {
      return this.trackList;
   }
   
   public Long getId() {
      return this.id;
   }
   
   @Override
   public int hashCode() {
      int hash = 0;
      hash += (this.id != null ? this.id.hashCode() : 0);
      return hash;
   }
   
   @Override
   public boolean equals(final Object object) {
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
      return "com.bradley.musicapp.domain.Album[ id=" + this.id + " ]";
   }
   
}
