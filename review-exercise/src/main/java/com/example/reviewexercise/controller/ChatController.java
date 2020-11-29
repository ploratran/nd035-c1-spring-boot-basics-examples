package com.example.reviewexercise.controller;

import com.example.reviewexercise.model.ChatForm;
import com.example.reviewexercise.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    // field:
    private MessageService messageService;

    // constructor:
    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    // handle GET to /chat
    // return messages from field "chatMessages" with list of messages:
    @GetMapping("/chat")
    public String getChatPage(ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String postChatMessage(ChatForm chatForm, Model model) {
        // add username and message in ChatForm to messageService's list:
        this.messageService.addMessage(chatForm);
        chatForm.setText("");
        model.addAttribute("chatMessages", this.messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[] { "Say", "Shout", "Whisper" };
    }
}
