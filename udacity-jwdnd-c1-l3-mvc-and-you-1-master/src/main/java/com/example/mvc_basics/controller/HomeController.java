package com.example.mvc_basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Register this class as a bean
 * and as a Controller with @Controller:
 */
@Controller
public class HomeController {

    // add a method to the Controller
    // mapping or forward request /home URL:
    // return a String that represents the template Spring should render for View:
    @RequestMapping("/home")
    public String getHomePage() {
        return "home";
    }

}
