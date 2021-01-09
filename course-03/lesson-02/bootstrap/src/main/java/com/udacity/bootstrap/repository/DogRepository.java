package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This is the layer to interact with database
 * CrudRepository<T,T>: use Spring Data JPA Repository,
 * to auto create simple queries behind the scene using method names
 * reduce boilerplate codes to implement data access layer for H2 DB
 * This is only an INTERFACE, which means Spring implements method on the fly
 * */
// an interface that extends Spring Crud API.
// CrudRepository<Dog, Long>
    // Dog: class name to create the Repository
    // Integer: data type of the primary key of the Repository class (Dog class)
public interface DogRepository extends CrudRepository<Dog, Long> {

    // NOTE: don't need to implement .findAll()

    // find a dog by breed:
    @Query("select d.id, d.breed from Dog d")
    List<String> findDogBreeds();

    // find a dog by its id:
    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findDogById(Long id);

    // find all dog names:
    @Query("select d.id, d.name from Dog d")
    List<String> findDogNames();
}