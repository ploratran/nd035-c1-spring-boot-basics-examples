package com.example.reviewexercise.service;

// Service class
// store a list of ChatMessage objects
import java.util.*;
import com.example.reviewexercise.model.ChatForm;
import com.example.reviewexercise.model.ChatMessage;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class MessageService {

    // field:
    private List<ChatMessage> chatMessages;

    // Spring called this annotated method once after initialization of bean properties:
    @PostConstruct
    public void postConstruct() {
        // store a list of ChatMessage objects:
        System.out.println("Creating MessageService bean: ");
        this.chatMessages = new ArrayList<>();
    }

    // add new messages to the stored list:
    // ChatForm argument is a form-backing object:
    public void addMessage(ChatForm chatForm) {
        // initialize new object of ChatMessage class:
        ChatMessage newMessage = new ChatMessage();

        // get username from Chat <form> field:
        newMessage.setUsername(chatForm.getUsername());

        // check "messageType" field in <form>
        // set form's text field either Say, Shout or Whisper:
        switch(chatForm.getMessageType()) {
            case "Say":
                newMessage.setMessage(chatForm.getText());
                break;
            case "Shout":
                newMessage.setMessage(chatForm.getText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setMessage(chatForm.getText().toLowerCase());
                break;
        }

        // add new message fields (username and text) into stored list:
        this.chatMessages.add(newMessage);
    }

    // get the list of messages:
    public List<ChatMessage> getChatMessages() {
        return this.chatMessages;
    }
}
