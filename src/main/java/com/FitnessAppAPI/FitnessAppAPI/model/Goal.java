package com.FitnessAppAPI.FitnessAppAPI.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goalId;

    @JsonView(View.Summary.class)
    private Integer goalNumber;

    @JsonView(View.Summary.class)
    @Enumerated(EnumType.STRING)
    @Column(name="GoalType")
    private GoalType goalType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AppUser appUser;

}
