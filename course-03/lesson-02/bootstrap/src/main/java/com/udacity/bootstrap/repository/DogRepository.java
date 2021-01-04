package com.udacity.bootstrap.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This is the layer to interact with database
 * CrudRepository<T,T>: use Spring Data JPA Repository,
 * to auto create simple queries behind the scene using method names
 * reduce boilerplate codes to implement data access layer for H2 DB
 * */
// an interface that extends Spring Crud API.
//
public interface DogRepository extends CrudRepository<String, Integer> {
    // query data for retrieveDogBreed():
    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    // query data for retrieveDogBreedById():
    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findDogBreedById(Long id);

    @Query("select d.id, d.name from Dog d")
    List<String> findDogNames();
}