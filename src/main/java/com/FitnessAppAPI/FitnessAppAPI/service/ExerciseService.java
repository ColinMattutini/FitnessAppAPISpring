package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.Exercise;

public interface ExerciseService {

    void saveExercise(Exercise exercise);
    void deleteExercise(Exercise exercise);
//    Exercise getExercise(Long id);

}
