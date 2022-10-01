package com.FitnessAppAPI.FitnessAppAPI.repo;

import com.FitnessAppAPI.FitnessAppAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
