package com.FitnessAppAPI.FitnessAppAPI.service;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Role;

import java.util.List;

public interface AppUserService {
    AppUser getAppUser(String username);
    AppUser saveAppUser(AppUser appuser);
    Role saveRole(Role role);
    List<AppUser> getAppUsers();

    String getFirstName(String username);
    void addRoleToAppUser(String username, String roleName);
}
