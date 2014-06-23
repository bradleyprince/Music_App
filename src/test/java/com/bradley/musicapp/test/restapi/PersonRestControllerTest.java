/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bradley.musicapp.test.restapi;


import com.bradley.musicapp.domain.Name;
import com.bradley.musicapp.domain.Person;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author bradley
 */
public class PersonRestControllerTest {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private final static String URL = "http://localhost:8085/musicapp/";
    
    @Test
    public void tesCreate(){
       Name name = new Name();
       name.setFirstName("bradley");
       name.setLastName("bradley");
       
       
       
       Person p = new Person.Builder().name(name).build();
       
       System.out.println("rest Template = " + restTemplate);
       HttpEntity<Person> requestEntity = new HttpEntity<>(p, getContentType());
//       Make the HTTP POST request, marshaling the request to JSON, and the response to a String
       
       ResponseEntity<String> responseEntity = restTemplate.
               exchange(URL + "api/person/create", HttpMethod.POST, requestEntity, String.class);
       System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
       System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
       System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders());
       
       Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        
    }
    
    
    public void testRead(){
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Person[]> responseEntity = restTemplate.exchange("URL",HttpMethod.GET,requestEntity, Person[].class);
        
        Person [] people = responseEntity.getBody();
        for (Person person : people) {
            
            
        }
       
    }
    
    private HttpEntity<?> getHttpEntity(){
         HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    private HttpHeaders getContentType() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;

    }
    
}
