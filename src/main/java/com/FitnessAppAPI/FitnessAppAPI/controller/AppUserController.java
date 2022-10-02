package com.FitnessAppAPI.FitnessAppAPI.controller;

import com.FitnessAppAPI.FitnessAppAPI.model.AppUser;
import com.FitnessAppAPI.FitnessAppAPI.model.Role;
import com.FitnessAppAPI.FitnessAppAPI.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveAppUser(@RequestBody AppUser appUser){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveAppUser(appUser));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveRole(role));
    }

    @PostMapping("/role/adduserrole")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        appUserService.addRoleToAppUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }


}

@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
