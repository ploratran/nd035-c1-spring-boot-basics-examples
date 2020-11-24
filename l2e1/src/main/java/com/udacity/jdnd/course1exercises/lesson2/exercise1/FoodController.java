package com.udacity.jdnd.course1exercises.lesson2.exercise1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for receiving requests.
 * allows Spring to find this component with @ComponentScan
 * and tells Spring to use this class to handle web requests
 */
@Controller
@RequestMapping("/food")
public class FoodController {

    // reference to FoodService:
    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public String getHomePage(FoodForm foodForm, Model model) {
        foodService.addFood(foodForm.getFoodName(), foodForm.getCalories(), foodForm.getMealTime());
        return "foodAdded";
    }

}
