package com.example.mvc_basics;

// a Data Class, Not a Component Class:
// store Form's data for requests:
public class MessageForm {
    // field
    // has to match the <input> th:field in the <form>:
    private String text;

    // methods:
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
