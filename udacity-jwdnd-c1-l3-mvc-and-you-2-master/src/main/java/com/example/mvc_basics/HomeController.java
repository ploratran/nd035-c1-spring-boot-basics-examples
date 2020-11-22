package com.example.mvc_basics;

 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    @RequestMapping("/home")
    // add "model" parameter to Controller's method:
    public String getHomePage(Model model) {
        // add attribute "welcomeMessage" to a map-like object model:
        model.addAttribute("welcomeMessage", "Current time is: " + Instant.now().toString());
        return "home";
    }

}


