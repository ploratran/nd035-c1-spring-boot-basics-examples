package com.udacity.jwdnd.spring_security_basics.model;

// Java class to match MESSAGES database table:
public class ChatMessage {
    private int messageId;
    private String username;
    private String messageText;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
