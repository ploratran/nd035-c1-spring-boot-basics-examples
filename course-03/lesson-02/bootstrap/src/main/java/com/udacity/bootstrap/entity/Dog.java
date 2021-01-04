package com.udacity.bootstrap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Create an entity called Dog:
@Entity
public class Dog {

    /** first, define unique id for each dog:
     * @Id: indicate the field is the primary key of current entity
     * @GeneratedValue: configure way to increment specified field
     * (strategy = GenerationType.AUTO): auto increment field
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // define 3 attributes: name, breed, origin:
    private String name;
    private String breed;
    private String origin;

    // constructor:

    // constructor for dog with all data:
    public Dog(Long id, String name, String breed, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    // constructor for dog with name and breed only:
    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    // constructor for empty data:
    public Dog() {}

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