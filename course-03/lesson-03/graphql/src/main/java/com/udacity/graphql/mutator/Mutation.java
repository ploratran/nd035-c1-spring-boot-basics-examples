package com.udacity.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphql.Entity.Dog;
import com.udacity.graphql.Repository.DogRepository;
import com.udacity.graphql.exception.BreedNotFoundException;
import com.udacity.graphql.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

// tells Spring to identify this class as a Component:
@Component
public class Mutation implements GraphQLMutationResolver {

    // wire DogRepository:
    private DogRepository dogRepository;

    // constructor:
    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    // delete dog breed:
    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = this.dogRepository.findAll();

        // iterate thru all dogs to check their breed:
        for (Dog d : allDogs) {
            if (d.getBreed().equals(breed)) {
                this.dogRepository.delete(d);
                deleted = true;
            }
        }

        // throw exception if the breed does not exist:
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return deleted;
    }

    // update a dog:
    public Dog updateDogName(String newName, Long id) {
        // find dog by id:
        Optional<Dog> optionalDog = this.dogRepository.findById(id);

        // if a dog with id exists:
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            // set new name to that dog:
            dog.setName(newName);
            // save new dog name into db:
            this.dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}