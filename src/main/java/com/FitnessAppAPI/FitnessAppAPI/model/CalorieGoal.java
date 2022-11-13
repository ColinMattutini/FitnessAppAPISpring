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

    public CalorieGoal(AppUser appUser){
        this.calorieGoal = 2400;
        this.username = appUser.getUsername();
        this.appUser = appUser;
    }
}
