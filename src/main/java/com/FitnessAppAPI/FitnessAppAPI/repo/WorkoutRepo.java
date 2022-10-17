package com.FitnessAppAPI.FitnessAppAPI.repo;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepo  extends JpaRepository<Workout, Long> {

    List<Workout> findByappUser(AppUser appUser);
    Workout findByworkoutId(Long id);
}
