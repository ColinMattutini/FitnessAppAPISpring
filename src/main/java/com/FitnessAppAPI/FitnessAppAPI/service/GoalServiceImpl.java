package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Goal;
import com.FitnessAppAPI.FitnessAppAPI.repo.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalServiceImpl implements GoalService{

    @Autowired
    GoalRepo goalRepo;
    AppUserServiceImpl appUserService;

    @Override
    public void saveGoal(Goal goal, String username) {

        goalRepo.save(goal);
    }

    @Override
    public List<Goal> findUserGoals(AppUser appUser) {
        List<Goal> goals = new ArrayList<>();
        goalRepo.findByappUser(appUser).forEach(goals::add);
        return goals;
    }
}
