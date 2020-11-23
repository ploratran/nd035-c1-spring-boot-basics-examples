package com.example.mvc_basics;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageListService {
    // fields:
    private List<String> messages;

    // constructor:
    public MessageListService() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }
}
