package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import com.FitnessAppAPI.FitnessAppAPI.service.FoodEntryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FoodEntryController {


    private final FoodEntryServiceImpl foodEntryService;

    @PostMapping("/foodEntry")
    public void addFoodEntry(@RequestBody FoodEntry foodEntry){ //, @PathVariable String username){
        //foodEntryService.getFoodEntryByUsername(username);
        foodEntryService.saveFoodEntry(foodEntry);
    }
}
