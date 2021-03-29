package com.udacity.course4.entity;

import javax.persistence.Entity;

// Create a new class called Shrub and add attributes for height and width:
// Shrubs should have separate tables for their unique fields (JOINED):
@Entity
public class Shrub extends Plant {

    private Double height;
    private Double width;

    // Entity must provide a public no-arg constructor:
    public Shrub() {}

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}
