package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Exercise;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import com.FitnessAppAPI.FitnessAppAPI.repo.ExerciseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    ExerciseRepo exerciseRepo;

    @Override
    public void saveExercise(Exercise exercise) {
        exerciseRepo.save(exercise);
    }

    @Override
    public void deleteExercise(Exercise exercise) {
        exerciseRepo.delete(exercise);
    }

//    @Override
//    public Exercise getExercise(Long workoutId) {
//        return exerciseRepo.getById(workoutId);
//    }

    public List<Exercise> findExercisesByWorkout(Workout workout){
        List<Exercise> exercises = new ArrayList<>();
        exerciseRepo.findByWorkout(workout).forEach(exercises::add);
        return exercises;
    }
}
