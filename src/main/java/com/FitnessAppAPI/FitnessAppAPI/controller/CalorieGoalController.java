package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.CalorieGoal;
import com.FitnessAppAPI.FitnessAppAPI.repo.CalorieGoalRepo;
import com.FitnessAppAPI.FitnessAppAPI.service.AppUserServiceImpl;
import com.FitnessAppAPI.FitnessAppAPI.service.CalorieGoalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CalorieGoalController {

    private final CalorieGoalServiceImpl calorieGoalService;
    private final AppUserServiceImpl appUserService;
    private final CalorieGoalRepo calorieGoalRepo;

    @PostMapping("/caloriegoal/{username}")
    public CalorieGoal addCalorieGoal(@RequestBody CalorieGoal calorieGoal, @PathVariable String username){
        AppUser appUser = appUserService.getAppUser(username);
        calorieGoal.setAppUser(appUser);
        calorieGoal.setUsername(username);
        return calorieGoalRepo.save(calorieGoal);
    }

    @PutMapping("caloriegoal/{username}")
    public void updateCalorieGoal(@RequestBody CalorieGoal calorieGoal, @PathVariable String username){
        calorieGoalService.updateCalorieGoal(calorieGoal);
    }

    @GetMapping("caloriegoal/{username}")
    public int getCalorieGoal(@PathVariable String username){
        return calorieGoalService.getCalorieGoal(username);
    }
}
