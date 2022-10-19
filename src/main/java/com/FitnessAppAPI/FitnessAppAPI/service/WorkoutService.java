package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutService{

    void saveWorkout(Workout workout);
    List<Workout> getAllWorkouts(AppUser appUser);
    void deleteWorkout(Workout workout);
    void updateWorkout(Workout workout, Long id);

    Workout getWorkoutById(Long id);
}
