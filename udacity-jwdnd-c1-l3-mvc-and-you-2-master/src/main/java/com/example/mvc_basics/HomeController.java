package com.example.mvc_basics;

 import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
public class HomeController {

    // fields:
    private MessageListService messageListService;

    // constructor:
    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    //    @RequestMapping("/home")

    // Also respond to GET request:
    @GetMapping("/home")
    // add "model" parameter to Controller's method
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        // add attribute "welcomeMessage" to a map-like object model:
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }

}


