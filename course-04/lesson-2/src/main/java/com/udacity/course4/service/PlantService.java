package com.udacity.course4.service;

import com.udacity.course4.data.Plant;
import org.springframework.stereotype.Service;

// a Plant Service that returns a Plant instance:
@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
