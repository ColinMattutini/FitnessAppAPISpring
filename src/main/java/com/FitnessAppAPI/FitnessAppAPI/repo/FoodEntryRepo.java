package com.FitnessAppAPI.FitnessAppAPI.repo;

import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FoodEntryRepo extends JpaRepository<FoodEntry, Long> {

    FoodEntry findByDate(Date date);
    List<FoodEntry> findByusername(String username);

}
