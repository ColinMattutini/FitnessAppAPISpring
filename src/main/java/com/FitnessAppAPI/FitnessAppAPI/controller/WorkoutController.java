package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Exercise;
import com.FitnessAppAPI.FitnessAppAPI.model.View;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import com.FitnessAppAPI.FitnessAppAPI.service.AppUserServiceImpl;
import com.FitnessAppAPI.FitnessAppAPI.service.ExerciseServiceImpl;
import com.FitnessAppAPI.FitnessAppAPI.service.WorkoutServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class WorkoutController {

    private final AppUserServiceImpl appUserService;
    private final WorkoutServiceImpl workoutService;
    private final ExerciseServiceImpl exerciseService;

    @PostMapping("/user/{username}/workout")
    public void saveWorkout(@RequestBody Workout workout, @PathVariable String username){
        AppUser appUser = appUserService.getAppUser(username);
        workout.setAppUser(appUser);
        workoutService.saveWorkout(workout);
    }

    @CrossOrigin(origins = "http://localhost:3000/workoutpage")
    @JsonView(View.Summary.class)
    @GetMapping("user/{username}/workout")
    public List<Workout> getAllWorkout(@PathVariable String username){
        AppUser appUser = appUserService.getAppUser(username);
        return workoutService.getAllWorkouts(appUser);

    }

    @JsonView(View.Summary.class)
    @GetMapping("user/{username}/workout/{workoutId}")
    public Workout getWorkoutById(@PathVariable Long workoutId){
        Workout workout = workoutService.getWorkoutById(workoutId);
        return workout;

    }

    @DeleteMapping("user/{username}/workout/{workoutId}")
    public void deleteWorkoutById(@PathVariable Long workoutId){
        List<Exercise> exercises = exerciseService.findExercisesByWorkout(workoutService.getWorkoutById(workoutId));
        for(int i = 0; i < exercises.size(); i++) {
            exerciseService.deleteExercise(exercises.get(i));
        }
        Workout workout = workoutService.getWorkoutById(workoutId);
        workoutService.deleteWorkout(workout);
    }

}
