package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import com.FitnessAppAPI.FitnessAppAPI.repo.FoodEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class FoodEntryServiceImpl implements FoodEntryService{

    @Autowired
    FoodEntryRepo foodEntryRepo;

    @Override
    public void saveFoodEntry(FoodEntry foodEntry) {
        foodEntryRepo.save(foodEntry);

    }

    @Override
    public FoodEntry getFoodEntryByUsername(String username) {
        return null;
    }
}
