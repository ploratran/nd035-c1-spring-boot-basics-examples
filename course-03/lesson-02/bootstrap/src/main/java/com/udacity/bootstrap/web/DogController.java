package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    // use DogService:
    private DogService dogService;

    @Autowired
    // auto wired a dog service bean:
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    // retrieve all dogs:
    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    // retrieve list of dog breeds:
    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);

    }

    // retrieve list of dog breeds by id:
    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable("id") Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    // retrieve list of dog names:
    @GetMapping("/allNames")
    public ResponseEntity<List<String>> getAllNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

}