package com.udacity.course4.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.course4.entity.Plant;
import com.udacity.course4.dto.PlantDTO;
import com.udacity.course4.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// Translation between DTO and Entity happens inside the Controller:
@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    // method that return a PlantDTO that includes only the name and price:
    @GetMapping("/dto")
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

    @PostMapping
    public Long newPlant(Plant plant){
        return this.plantService.save(plant);
    }

    // a method to get plant by id if it is delivered:
    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long plantId) {
        return this.plantService.delivered(plantId);
    }

    // a method to get a list of plants that are cheaper than a specified price:
    @GetMapping("/price-under/{price}")
    public List<Plant> plantsCheaperThan(@PathVariable BigDecimal price) {
        return this.plantService.findPlantsBelowPrice(price);
    }
}