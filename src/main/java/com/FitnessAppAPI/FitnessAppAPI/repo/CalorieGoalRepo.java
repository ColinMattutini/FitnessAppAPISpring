package com.FitnessAppAPI.FitnessAppAPI.repo;

import com.FitnessAppAPI.FitnessAppAPI.model.CalorieGoal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalorieGoalRepo extends JpaRepository<CalorieGoal, Long> {
    CalorieGoal findByUsername(String username);
}
