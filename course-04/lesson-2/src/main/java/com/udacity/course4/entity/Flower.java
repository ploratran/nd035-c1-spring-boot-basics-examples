package com.udacity.course4.entity;

import javax.persistence.*;

// Turn Flower into a subclass of Plant that just has the attribute color:
// Flowers should have separate tables for their unique fields (JOINED):
@Entity
public class Flower extends Plant {

    private String color;

    // Entity must provide a public no-arg constructor:
    public Flower() {}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

