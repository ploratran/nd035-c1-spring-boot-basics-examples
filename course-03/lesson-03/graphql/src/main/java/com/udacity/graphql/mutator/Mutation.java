package com.udacity.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.graphql.entity.Dog;
import com.udacity.graphql.repository.DogRepository;
import com.udacity.graphql.exception.BreedNotFoundException;
import com.udacity.graphql.exception.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        // Loop through all dogs to check their breed
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                // Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }
        }
        // Throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            // Set the new name and save the updated dog
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}

// tells Spring to identify this class as a Component:
//@Component
//public class Mutation implements GraphQLMutationResolver {
//
//    // wire DogRepository:
//    private DogRepository dogRepository;
//
//    // constructor:
//    public Mutation(DogRepository dogRepository) {
//        this.dogRepository = dogRepository;
//    }
//
//    // delete dog breed:
//    public boolean deleteDogBreed(String breed) {
//        boolean deleted = false;
//        Iterable<Dog> allDogs = this.dogRepository.findAll();
//
//        // iterate thru all dogs to check their breed:
//        for (Dog d : allDogs) {
//            if (d.getBreed().equals(breed)) {
//                this.dogRepository.delete(d);
//                deleted = true;
//            }
//        }
//
//        // throw exception if the breed does not exist:
//        if (!deleted) {
//            throw new BreedNotFoundException("Breed Not Found", breed);
//        }
//
//        return deleted;
//    }
//
//    // update a dog:
//    public Dog updateDogName(String newName, Long id) {
//        // find dog by id:
//        Optional<Dog> optionalDog = this.dogRepository.findById(id);
//
//        // if a dog with id exists:
//        if (optionalDog.isPresent()) {
//            Dog dog = optionalDog.get();
//            // set new name to that dog:
//            dog.setName(newName);
//            // save new dog name into db:
//            this.dogRepository.save(dog);
//            return dog;
//        } else {
//            throw new DogNotFoundException("Dog Not Found", id);
//        }
//    }
//}