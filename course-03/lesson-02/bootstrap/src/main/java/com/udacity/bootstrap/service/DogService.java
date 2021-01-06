package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {

    // retrieve all dogs:
    List<Dog> retrieveAllDogs();

    // retrieve a dog breed:
    List<String> retrieveDogBreeds();

    // retrieve a dog breed by its id:
    String retrieveDogBreedById(int id);

    // retrieve all dog names:
    List<String> retrieveDogNames();
}