package com.udacity.course4.service;

import com.udacity.course4.entity.Plant;
import com.udacity.course4.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

// a Plant Service that returns a Plant instance:
@Service
public class PlantService {

    // inject an instance of PlantRepository:
    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name) {
        // return a Plant instance:
        return new Plant();
    }

    // inject an instance of PlantRepository to create service methods that do:
    // 1. Save a new Plant and returns its Id
    public Long save(Plant plant) {
        return plantRepository.save(plant).getId();
    }
    // 2. Check if a plant has been delivered
    public Boolean delivered(Long plantId) {
        return plantRepository.deliveryCompleted(plantId);
    }
    // 3. Find a list of plants cheaper than a specified amount
    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }
}
