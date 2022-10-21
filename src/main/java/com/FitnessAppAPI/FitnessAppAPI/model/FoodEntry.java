package com.FitnessAppAPI.FitnessAppAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_entry")
public class FoodEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long entryId;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "app_user_username")
//    @JoinColumn(name = "id", referencedColumnName = "id",insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AppUser appUser;
    private String username;
    private String foodName;
    private Integer calories;
    private String date;
}
