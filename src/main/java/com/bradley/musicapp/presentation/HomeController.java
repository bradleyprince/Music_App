/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bradley.musicapp.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Balla
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
}
