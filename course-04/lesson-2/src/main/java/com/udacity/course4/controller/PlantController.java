package com.udacity.course4.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.course4.data.Plant;
import com.udacity.course4.dto.PlantDTO;
import com.udacity.course4.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Translation between DTO and Entity happens inside the Controller:
@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // method that return a PlantDTO that includes only the name and price:
    @GetMapping
    public PlantDTO getPlantDTO(String name){
        // use Plant Service to get Plant Entity by its name:
        Plant plant = this.plantService.getPlantByName(name);
        // return the converted Plant DTO using convertEntityToDTO():
        return convertEntityToDTO(plant);
    }


    // return a Plant Entity instance with only name and price:
    @GetMapping
    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name){
        return this.plantService.getPlantByName(name);
    }

    // a method to convert the Plant Entity into a PlantDTO
    // return a Plant DTO:
    private static PlantDTO convertEntityToDTO(Plant plant) {
        // initialize a Plant DTO object:
        PlantDTO plantDTO = new PlantDTO();
        // use BeanUtils to copy properties of Entity to DTO:
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
}