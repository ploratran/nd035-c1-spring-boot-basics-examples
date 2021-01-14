package com.example.consuming.entity;

public class Dog {

    // fields:
    private String message;
    private String status;

    // constructor:
    public Dog() {}

    public Dog(String message, String status) {
        this.message = message;
        this.status = status;
    }

    // getters and setters:

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dog {" +
                "link=" + message +
                ", status=" + status  +
                "}";
    }
}
