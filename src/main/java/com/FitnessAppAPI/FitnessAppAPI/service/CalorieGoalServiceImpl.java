package com.FitnessAppAPI.FitnessAppAPI.service;


import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.CalorieGoal;
import com.FitnessAppAPI.FitnessAppAPI.model.FoodEntry;
import com.FitnessAppAPI.FitnessAppAPI.model.Role;
import com.FitnessAppAPI.FitnessAppAPI.repo.CalorieGoalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CalorieGoalServiceImpl implements CalorieGoalService{

    private final CalorieGoalRepo calorieGoalRepo;
    private final AppUserServiceImpl appUserService;

    @Override
    public CalorieGoal saveCalorieGoal(CalorieGoal calorieGoal) {
//        AppUser appUser = appUserRepo.findByUsername(username);
        return calorieGoalRepo.save(calorieGoal);
    }

    @Override
    public int getCalorieGoal(String username) {
        CalorieGoal calorieGoal = calorieGoalRepo.findByUsername(username);
        return calorieGoal.getCalorieGoal();

    }

    @Override
    public void updateCalorieGoal(CalorieGoal calorieGoal) {
        Optional<CalorieGoal> f = Optional.ofNullable(calorieGoalRepo.findByUsername(calorieGoal.getUsername()));
        if(f.isPresent()){
            CalorieGoal calorieGoalToUpdate = f.get();
            calorieGoalToUpdate.setGoalid(calorieGoalToUpdate.getGoalid());
            calorieGoalToUpdate.setUsername(calorieGoalToUpdate.getUsername());
            calorieGoalToUpdate.setCalorieGoal(calorieGoal.getCalorieGoal());
            calorieGoalToUpdate.setAppUser(calorieGoalToUpdate.getAppUser());
            calorieGoalRepo.save(calorieGoalToUpdate);

        } else{
            calorieGoal.setAppUser(appUserService.getAppUser(calorieGoal.getUsername()));
            calorieGoalRepo.save(calorieGoal);
        }
    }

}
