package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.*;
import com.FitnessAppAPI.FitnessAppAPI.repo.AppUserRepo;
import com.FitnessAppAPI.FitnessAppAPI.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    private final CalorieGoalServiceImpl calorieGoalService;
    private final GoalServiceImpl goalService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByUsername(username);
        if(appUser == null){
            log.error("Username {} not found", username);
            throw new UsernameNotFoundException("User {} not found in database. Please check if the username is spelled correctly.");
        } else {
            log.info("User {} found in database successfully.", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), authorities);
    }

    @Override
    public AppUser getAppUser(String username) {
        return appUserRepo.findByUsername(username);
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving user {} to the database", appUser.getUsername());
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        String username = appUser.getUsername();
        appUserRepo.save(appUser);
        addRoleToAppUser(username, "ROLE_USER");
        CalorieGoal calorieGoal = new CalorieGoal(appUser);
        calorieGoalService.saveCalorieGoal(calorieGoal);
        Goal goal1 = new Goal(GoalType.SLEEP, appUser);
        Goal goal2 = new Goal(GoalType.WATER, appUser);
        Goal goal3 = new Goal(GoalType.STEPS, appUser);
        goalService.saveGoal(goal1, appUser.getUsername());
        goalService.saveGoal(goal2, appUser.getUsername());
        goalService.saveGoal(goal3, appUser.getUsername());
        return appUser;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepo.findAll();
    }

    @Override
    public String getFirstName(String username) {
        String name = getAppUser(username).getFirstName();
        return name;
    }

    @Override
    public void addRoleToAppUser(String username, String roleName) {
        AppUser appUser = appUserRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }


}
