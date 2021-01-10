package com.udacity.dogmicroservice.repository;

import com.udacity.dogmicroservice.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

}