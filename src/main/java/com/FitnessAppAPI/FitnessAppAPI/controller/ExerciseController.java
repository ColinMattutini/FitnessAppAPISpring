package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.Exercise;
import com.FitnessAppAPI.FitnessAppAPI.model.View;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import com.FitnessAppAPI.FitnessAppAPI.repo.ExerciseRepo;
import com.FitnessAppAPI.FitnessAppAPI.service.ExerciseServiceImpl;
import com.FitnessAppAPI.FitnessAppAPI.service.WorkoutServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ExerciseController {

    private final ExerciseRepo exerciseRepo;
    private final ExerciseServiceImpl exerciseService;
    private final WorkoutServiceImpl workoutService;

    @PostMapping("/user/{username}/workout/{workoutId}/exercise")
    public void saveExercise(@RequestBody Exercise exercise, @PathVariable String username, @PathVariable Long workoutId){
        Workout workout = workoutService.getWorkoutById(workoutId);
        exercise.setWorkout(workout);
        exerciseService.saveExercise(exercise);
    }

    @JsonView(View.Summary.class)
    @GetMapping("/user/{username}/workout/{workoutId}/exercise")
    public List<Exercise> getUserExercises(@PathVariable Long workoutId){
        Workout workout = workoutService.getWorkoutById(workoutId);
        return exerciseService.findExercisesByWorkout(workout);
    }

    @DeleteMapping("/user/{username}/workout/{workoutId}/exercise/{exerciseId}")
    public void deleteExercise(@PathVariable Long exerciseId){
        exerciseService.deleteExercise(exerciseService.getExercise(exerciseId));
    }

}
