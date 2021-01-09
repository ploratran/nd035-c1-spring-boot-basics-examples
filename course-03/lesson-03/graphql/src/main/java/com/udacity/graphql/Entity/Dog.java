package com.udacity.graphql.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Dog {
    // define attributes/fields:
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) Long id;

    private String name;
    private String breed;
    private String origin;

    // constructors:
    public Dog() {}

    public Dog(Long id, String name, String breed, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dog(Long id, String name, String breed) {
        this.id = id;
        this.breed = breed;
        this.name = name;
    }

    // getters and setters:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}