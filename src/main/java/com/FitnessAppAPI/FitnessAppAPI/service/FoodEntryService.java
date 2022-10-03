package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import org.springframework.data.jpa.repository.Query;

public interface FoodEntryService {
    void saveFoodEntry(FoodEntry foodEntry);
    FoodEntry getFoodEntryByUsername(String username);
    //Get food entries by userId... take in username... already in token... change foodEntry entity to have
    //foreign key of username not userId?




    //FoodEntry deletion by foodEntry Id
    //FoodEntry update (put) by foodEntry Id
}
