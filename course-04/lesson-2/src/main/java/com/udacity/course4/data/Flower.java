package com.udacity.course4.data;

import javax.persistence.*;

// Turn Flower into a subclass of Plant that just has the attribute color:
// Flowers should have separate tables for their unique fields
@Entity
public class Flower extends Plant{

    private String color;

    public Flower() {}

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

