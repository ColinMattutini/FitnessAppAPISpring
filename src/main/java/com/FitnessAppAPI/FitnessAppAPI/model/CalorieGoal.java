package com.FitnessAppAPI.FitnessAppAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calorie_goal")
public class CalorieGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goalid;
    private Integer calorieGoal;
    private String username;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AppUser appUser;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
//    private AppUser appUser;


//
//    public AppUser getAppUser(){
//        return appUser;
//    }
//
//    public void setAppUser(AppUser appUser){
//        this.appUser = appUser;
//    }
//    private String username;
}
