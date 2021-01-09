package com.udacity.bootstrap.service;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is a service layer
 *
 * */
@Service
public class DogServiceImpl implements DogService {

    // auto wired repository to use for service:
    @Autowired
    DogRepository dogRepository;

    // method to find all dogs:
    public List<Dog> retrieveAllDogs() {
        return (List<Dog>) this.dogRepository.findAll();
    }

    // method to find all dog breeds:
    public List<String> retrieveDogBreeds() {
        return (List<String>) this.dogRepository.findDogBreeds();
    }

    // method to find dog breed by its id:
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findDogById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    // method to find all dog names:
    public List<String> retrieveDogNames() {
        return (List<String>) this.dogRepository.findDogNames();
    }
}