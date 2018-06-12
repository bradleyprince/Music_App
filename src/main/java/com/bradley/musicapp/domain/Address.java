/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 *
 * @author Balla
 */
@Embeddable
public class Address implements Serializable{
   
   private static final long serialVersionUID = 6106674153190698124L;
   
   private String homeAddress;
   private String postalAddress;
   private String emailAddress;
   
   public String getHomeAddress() {
      return this.homeAddress;
   }
   
   public void setHomeAddress(final String homeAddress) {
      this.homeAddress = homeAddress;
   }
   
   public String getPostalAddress() {
      return this.postalAddress;
   }
   
   public void setPostalAddress(final String postalAddress) {
      this.postalAddress = postalAddress;
   }
   
   public String getEmailAddress() {
      return this.emailAddress;
   }
   
   public void setEmailAddress(final String emailAddress) {
      this.emailAddress = emailAddress;
   }
   
}
