package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Goal;
import com.FitnessAppAPI.FitnessAppAPI.repo.GoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public void updateGoal(Goal goal, AppUser appUser) {
        List<Goal> g = findUserGoals(appUser).stream().filter(e -> e.getGoalType().equals(goal.getGoalType())).collect(Collectors.toList());
        if(g.size() > 0){
            Goal goalToUpdate = g.get(0);
            goalToUpdate.setGoalNumber(goal.getGoalNumber());
            goalRepo.save(goalToUpdate);
        }
    }
}
