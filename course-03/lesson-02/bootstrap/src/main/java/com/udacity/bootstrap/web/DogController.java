package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Dog;
import com.udacity.bootstrap.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @RestController combines @Controller and @ResponseBody
// @ApiResponses allows to customize response messages:
@ApiResponses(value = {
        // @ApiResponse defines each error message for each code:
        @ApiResponse(code=400, message = "This is a bad request."),
        @ApiResponse(code=401, message="Your access request cannot be authorized."),
        @ApiResponse(code=404, message="This dog is not found."),
        @ApiResponse(code=500, message = "The server is down.")
})
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
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id) {
        String breed = this.dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    // get all dog names:
    public ResponseEntity<List<String>> getAllDogNames() {
        List<String> list = this.dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }
}