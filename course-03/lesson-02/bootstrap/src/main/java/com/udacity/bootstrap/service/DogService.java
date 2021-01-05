package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {

    // retrieve all dogs:
    List<Dog> retrieveDogs();

    // retrieve a dog breed:
    List<Dog> retrieveDogBreed();

    // retrieve a dog breed by its id:
    String retrieveDogBreedById();

    // retrieve all dog names:
    List<Dog> retrieveDogNames();
}