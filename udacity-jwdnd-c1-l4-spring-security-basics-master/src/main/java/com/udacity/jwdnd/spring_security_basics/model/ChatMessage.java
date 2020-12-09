package com.udacity.jwdnd.spring_security_basics.model;

// Java class to match MESSAGES database table:
public class ChatMessage {
    private int messageid;
    private String username;
    private String messagetext;

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }
}
