package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import com.FitnessAppAPI.FitnessAppAPI.service.AppUserServiceImpl;
import com.FitnessAppAPI.FitnessAppAPI.service.FoodEntryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FoodEntryController {
    private final FoodEntryServiceImpl foodEntryService;
    private final AppUserServiceImpl appUserService;

    @PostMapping("/user/{username}/foodEntry")
    public void addFoodEntry(@RequestBody FoodEntry foodEntry, @PathVariable String username){
        if(appUserService.getAppUser(username).equals(null)){
            throw new IllegalArgumentException("Username does not exist in Database.");
        }else{
            foodEntry.setUsername(username);
            foodEntryService.saveFoodEntry(foodEntry);
        }

    }
    @GetMapping("/user/{username}/foodEntry")
    public List<FoodEntry> getFoodEntries(@PathVariable String username){
        if(appUserService.getAppUser(username).equals(null)){
            throw new IllegalArgumentException("Username does not exist in Database.");
        }else{
            return foodEntryService.getFoodEntries(username);
        }

    }

    @PutMapping("/user/{username}/foodEntry/{id}")
    public void updateFoodEntry(@RequestBody FoodEntry foodEntry, @PathVariable String username, @PathVariable Long id){
        foodEntryService.updateFoodEntry(foodEntry, id);
    }

    @DeleteMapping("user/{username}/foodEntry/{id}")
    public void deleteFoodEntry(@PathVariable Long id){
        foodEntryService.deleteFoodEntry(id);
    }
}
