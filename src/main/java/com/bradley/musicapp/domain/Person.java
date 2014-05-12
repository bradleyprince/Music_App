/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.domain;

import java.io.Serializable;
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
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="artist_id")
    private Artist artist;
    @Embedded
    private Contact contact;
    @Embedded
    private Address address;

    private Person(Builder builder){
        id = builder.id;
        name = builder.name;
        artist = builder.artist;
        contact = builder.contact;
        address = builder.address;
    }
    
    private Person(){      
    }
    
    public static class Builder{
        private Long id;
        private String name;
        private Artist artist;
        private Contact contact;
        private Address address;
        
        public Builder(){           
        }
        
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        
        public Builder name(String value){
            this.name = value;
            return this;
        }
        
        public Builder artist(Artist value){
            this.artist = value;
            return this;
        }
        
        public Builder contact(Contact value){
            this.contact = value;
            return this;
        }
        
        public Builder address(Address value){
            this.address = value;
            return this;
        }
        
        public Builder person(Person person){
            id = person.getId();
            name = person.getName();
            artist = person.getArtist();
            contact = person.getContact();
            address = person.getAddress();
            
            return this;
        }
        
        public Person build(){
            return new Person(this);
        }
    }

    public Artist getArtist() {
        return artist;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
    
    public String getName() {
        return name;
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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bradley.musicapp.domain.Person[ id=" + id + " ]";
    }
    
}
