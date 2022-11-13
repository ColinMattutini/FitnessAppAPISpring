package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.CalorieGoal;

public interface CalorieGoalService {

    void saveCalorieGoal(CalorieGoal calorieGoal);
    int getCalorieGoal(String username);
    void updateCalorieGoal(CalorieGoal calorieGoal);

}
