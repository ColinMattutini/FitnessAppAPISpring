package com.FitnessAppAPI.FitnessAppAPI.repo;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepo extends JpaRepository<Goal, Long> {
    List<Goal> findByappUser(AppUser appUser);
}
