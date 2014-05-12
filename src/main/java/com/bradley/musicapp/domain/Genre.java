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
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    private Genre(Builder builder){
        id = builder.id;
        type = builder.type;
    }
    
    private Genre(){
    }
    
    public static class Builder{
        private Long id;
        private String type;
        
        public Builder(){           
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder type(String value){
            this.type = value;
            return this;
        }
        
        public Builder genre(Genre genre){
            id = genre.getId();
            type = genre.getType();
            
            return this;
        }
        
        public Genre build(){
            return new Genre(this);
        }
    }
    
    public String getType() {
        return type;
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
        if (!(object instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.musicapp.domain.Genre[ id=" + id + " ]";
    }
    
}
