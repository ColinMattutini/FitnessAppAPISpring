package com.FitnessAppAPI.FitnessAppAPI.repo;

import com.FitnessAppAPI.FitnessAppAPI.model.Exercise;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
    List<Exercise> findByWorkout(Workout workout);
    Exercise findByexerciseId(Long id);

}
