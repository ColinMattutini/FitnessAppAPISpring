package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Goal;

import java.util.List;

public interface GoalService {
    void saveGoal(Goal goal, String username);
    List<Goal> findUserGoals(AppUser appUser);

    void updateGoal(Goal goal, AppUser appUser);
}
