package com.udacity.jwdnd.spring_security_basics.controller;


import com.udacity.jwdnd.spring_security_basics.model.MessageForm;
import com.udacity.jwdnd.spring_security_basics.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    // fields:
    private MessageService messageService;

    // constructor:
    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    // handle GET request:
    @GetMapping
    //
    public String getChatPage(MessageForm messageForm, Model model) {
        // assign chatMessages form-backing object with all messages in database:
        model.addAttribute("chatMessages", this.messageService.getMessages());
        return "chat";
    }

    // handle POST request:
    @PostMapping
    public String postChatMessage(Authentication authentication, MessageForm messageForm, Model model) {
        // set username to the currently logged in user:
        messageForm.setUsername(authentication.getName());
        // add message
        this.messageService.addMessage(messageForm);
        // reset input message to blank:
        messageForm.setMessageText("");
        // assign chatMessages form-backing object with all messages in database:
        model.addAttribute("chatMessages", this.messageService.getMessages());
        return "chat";
    }

    // define an array with form-backing object allMessageTypes to either Say, Shout or Whisper:
    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[] {"Say", "Shout", "Whisper"};
    }
}