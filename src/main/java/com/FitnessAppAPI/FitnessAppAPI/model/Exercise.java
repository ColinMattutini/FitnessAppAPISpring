package com.FitnessAppAPI.FitnessAppAPI.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Summary.class)
    private Long exerciseId;
    @JsonView(View.Summary.class)
    private String exerciseName;
    @JsonView(View.Summary.class)
    private Integer sets;
    @JsonView(View.Summary.class)
    private Integer reps;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "workoutId", referencedColumnName = "workoutId")
    private Workout workout;

}
