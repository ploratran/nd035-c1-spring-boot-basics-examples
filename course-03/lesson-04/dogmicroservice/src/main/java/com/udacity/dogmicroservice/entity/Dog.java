package com.udacity.dogmicroservice.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Dog {

    // define fields/attributes:
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;
    String breed;
    String origin;

    // constructors:
    public Dog() {}

    public Dog(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public Dog(String name, String breed, String origin, Long id) {
        this.name = name;
        this.breed = breed;
        this.origin = origin;
        this.id = id;
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
