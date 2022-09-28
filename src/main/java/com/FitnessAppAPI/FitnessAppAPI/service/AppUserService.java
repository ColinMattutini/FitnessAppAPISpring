package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Role;

public interface AppUserService {
    AppUser getAppUser(String username);
    AppUser saveAppUser(AppUser appuser);
    Role saveRole(Role role);
    void addRoleToAppUser(String username, String roleName);
}
