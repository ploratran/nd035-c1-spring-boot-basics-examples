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

// @RestController combines @Controller and @ResponseBody:
@RestController
public class DogController {

    // defines field to use Service layer:
    private DogService dogService;

    // auto wired Dog Service:
    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    // get all dogs:
    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = this.dogService.retrieveAllDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    // get all dog breeds:
    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getAllBreeds() {
        List<String> list = this.dogService.retrieveDogBreeds();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    // get a dog by its id:
    @GetMapping("/dogs/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable("id") int id) {
        String dog = this.dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(dog, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    // get all dog names:
    public ResponseEntity<List<String>> getAllDogNames() {
        List<String> list = this.dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}