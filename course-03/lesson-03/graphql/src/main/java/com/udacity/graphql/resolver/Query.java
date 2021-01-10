package com.udacity.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphql.Entity.Dog;
import com.udacity.graphql.Repository.DogRepository;
import com.udacity.graphql.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

// tells Spring to identify this class as a Component:
@Component
public class Query implements GraphQLQueryResolver {

    // wire Repository:
    private DogRepository dogRepository;

    // constructor:
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    // map the Root Query findAllDogs inside .graphqls:
    public Iterable<Dog> findAllDogs() {
        return this.dogRepository.findAll();
    }

    // map Root Query findDogById():
    public Dog findDogById(Long id) {
        Optional<Dog> optionalDog = this.dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}