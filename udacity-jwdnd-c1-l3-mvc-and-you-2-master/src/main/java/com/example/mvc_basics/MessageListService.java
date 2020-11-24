package com.example.mvc_basics;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageListService {
    // fields:
    final List<String> messages;

    // constructor:
    public MessageListService() {
        this.messages = new ArrayList<>();
    }

    // add new message to "messages" field:
    public void addMessage(String message) {
        this.messages.add(message);
    }

    // get the list of "messages":
    public List<String> getMessages() {
        return new ArrayList<>(this.messages);
    }
}
