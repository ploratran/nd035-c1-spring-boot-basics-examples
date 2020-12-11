package com.udacity.jwdnd.spring_security_basics.service;

import com.udacity.jwdnd.spring_security_basics.mapper.MessageMapper;
import com.udacity.jwdnd.spring_security_basics.model.ChatMessage;
import com.udacity.jwdnd.spring_security_basics.model.MessageForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    // fields:
    private MessageMapper messageMapper;
    // private List<String> messages;

    // constructor:
    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    // method to add new message:
    // use MessageForm to get data from user input:
    public void addMessage(MessageForm messageForm) {
        // initialize newMessage object form ChatMessage class:
        ChatMessage newMessage = new ChatMessage();
        // assign new message to the current user:
        // get username from MessageForm from frontend:
        newMessage.setUsername(messageForm.getUsername());

        // let user decide Say, Shout or Whisper mode of messageText:
        switch(messageForm.getMessageType()) {
            case "Say":
                newMessage.setMessageText(messageForm.getMessageText());
                break;
            case "Shout":
                newMessage.setMessageText(messageForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessageText(messageForm.getMessageText().toLowerCase());
                break;
        }
        // add new message to MESSAGES database:
        messageMapper.addMessage(newMessage);
    }

    // retrieve the list of messages from MESSAGES database:
    public List<ChatMessage> getMessages() {
        return messageMapper.getAllMessages();
    }
}
