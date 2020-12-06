package com.udacity.jwdnd.spring_security_basics.model;

public class ChatMessage {
    // fields:
    // only need to add 1 single field:
    private String messageText;

    // constructor:
    public ChatMessage(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
