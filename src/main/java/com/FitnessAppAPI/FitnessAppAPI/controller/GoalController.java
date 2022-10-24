package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Goal;
import com.FitnessAppAPI.FitnessAppAPI.model.View;
import com.FitnessAppAPI.FitnessAppAPI.service.AppUserServiceImpl;
import com.FitnessAppAPI.FitnessAppAPI.service.GoalServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class GoalController {

    private final GoalServiceImpl goalService;
    private final AppUserServiceImpl appUserService;

    @PostMapping("/goal/{username}")
    public void saveGoal(@RequestBody Goal goal, @PathVariable String username){
        AppUser appUser = appUserService.getAppUser(username);
        goal.setAppUser(appUser);
        goalService.saveGoal(goal, username);
    }

    @JsonView(View.Summary.class)
    @GetMapping("/goal/{username}")
    public List<Goal> getGoals(@PathVariable String username){
        AppUser appUser = appUserService.getAppUser(username);
        return goalService.findUserGoals(appUser);
    }
}
