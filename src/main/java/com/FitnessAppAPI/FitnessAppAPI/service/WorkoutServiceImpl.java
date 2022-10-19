package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import com.FitnessAppAPI.FitnessAppAPI.repo.WorkoutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    WorkoutRepo workoutRepo;

    @Override
    public void saveWorkout(Workout workout) {
        workoutRepo.save(workout);
    }

    @Override
    public List<Workout> getAllWorkouts(AppUser appUser) {
        List<Workout> workouts = new ArrayList<>();
        workoutRepo.findByappUser(appUser).forEach(workouts::add);

        return workouts;
    }

    @Override
    public void deleteWorkout(Workout workout) {
        workoutRepo.delete(workout);
    }

    @Override
    public void updateWorkout(Workout workout, Long id) {

    }

    @Override
    public Workout getWorkoutById(Long id) {
        return workoutRepo.findByworkoutId(id);
    }
}
