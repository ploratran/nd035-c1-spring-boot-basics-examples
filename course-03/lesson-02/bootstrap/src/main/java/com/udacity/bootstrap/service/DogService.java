package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;

import java.util.List;

public interface DogService {
    // retrieve all dogs:
    List<Dog> retrieveDogs();

    // retrieve list of dog breed:
    List<String> retrieveDogBreed();

    // retrieve a particular dog by its id:
    String retrieveDogBreedById(Long id);

    // retrieve a list of dog name:
    List<String> retrieveDogNames();
}