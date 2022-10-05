package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import com.FitnessAppAPI.FitnessAppAPI.repo.FoodEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodEntryServiceImpl implements FoodEntryService{

    @Autowired
    FoodEntryRepo foodEntryRepo;

    @Override
    public List<FoodEntry> getFoodEntries(String username) {
        List<FoodEntry> entries = new ArrayList<>();
        foodEntryRepo.findByusername(username).forEach(entries::add);
        return entries;
        //return foodEntryRepo.findByusername(username);
    }

    @Override
    public void updateFoodEntry(FoodEntry foodEntry, Long id) {
        Optional<FoodEntry> f = foodEntryRepo.findById(id);
        if(f.isPresent()){
            FoodEntry foodEntryToUpdate = f.get();
            foodEntryToUpdate.setEntryId(id);
            foodEntryToUpdate.setFoodName(foodEntry.getFoodName());
            foodEntryToUpdate.setUsername(foodEntryToUpdate.getUsername());
            foodEntryToUpdate.setCalories(foodEntry.getCalories());
            foodEntryRepo.save(foodEntryToUpdate);

        } else{throw new IllegalArgumentException("Food Entry not Found!");}

        //foodEntryRepo.save(foodEntry);
    }

    @Override
    public void deleteFoodEntry(Long id) {
        foodEntryRepo.deleteById(id);
    }

    @Override
    public void saveFoodEntry(FoodEntry foodEntry) {
        foodEntryRepo.save(foodEntry);

    }

    @Override
    public FoodEntry getFoodEntryByUsername(String username) {
        return null;
    }




}
