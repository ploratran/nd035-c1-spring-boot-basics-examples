package com.example.reviewexercise.controller;

import com.example.reviewexercise.model.ChatForm;
import com.example.reviewexercise.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    // field:
    private MessageService messageService;

    // constructor:
    // take MessageService object as argument
    // as Spring interprets as dependency:
    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    // handle GET to /chat
    // return messages from field "chatMessages" with list of messages
    // declare ChatForm object as argument
    // Spring will initialize the form-backing object for the template:
    @GetMapping
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    // declare ChatForm object as an argument
    // Spring will initialize with data from the request:
    @PostMapping
    public String postChatMessage(ChatForm chatForm, Model model) {
        // add username and message in ChatForm to messageService's list:
        this.messageService.addMessage(chatForm);
        // clear text of the form:
        chatForm.setText("");
        // update the list of chatMessages:
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    // tells Spring to make some values available
    // without repeating ourselves in every controller method
    // define the value for the <select> dropdown
    // and marks it with appropriate ModelAttribute name "allMessageTypes":
    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[] { "Say", "Shout", "Whisper" };
    }
    // think of @ModelAttribute as bean
    // but instead the value ending up in the Spring Application Context
    // values end up in Spring MVC model for the template to render
}
