package com.udacity.jdnd.course1exercises.lesson2.exercise1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Pretend repository implementation
 * @Repository is a specialized annotation of @Component for data access
 */
@Repository
public class FoodRepository {
    private Map<MealTime, List<FoodData>> foodDatabase = new EnumMap<>(MealTime.class);

    public List<FoodData> getFood(MealTime mealTime) {
        return foodDatabase.getOrDefault(mealTime, new ArrayList<>());
    }

    public void addFood(MealTime mealTime, FoodData food) {
        foodDatabase.getOrDefault(mealTime, new ArrayList<>()).add(food);
    }
}
