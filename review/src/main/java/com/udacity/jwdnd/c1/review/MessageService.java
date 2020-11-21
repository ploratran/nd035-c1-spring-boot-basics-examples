package com.udacity.jwdnd.c1.review;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

// define a class Component called "MessageService"
// that depends on "message" bean:
// label this as a @Service

@Service
public class MessageService {

    // Fields:
    private String message;

    // Constructor
    public MessageService(String message) {
        this.message = message;
    }


    // add an "uppercase" method to this class
    // return an upper case version of the "message" bean:
    public String uppercase() {
        return this.message.toUpperCase();
    }

    // add an "lowercase" method to this class
    // return a lower case version of the "message" bean:
    public String lowercase() {
        return this.message.toLowerCase();
    }

    // Spring will call @PostConstruct bean
    // after instantiate the bean and place it in Application Context:
    @PostConstruct
    public void postConstruct() {
        System.out.println("Create MessageService bean!");
    }
}
