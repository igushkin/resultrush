package com.example.ResultRush.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Target {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer targetId;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private Boolean isCompleted;
    @Basic(optional = false)
    private Instant createdUTC;
    private Instant completedUTC;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id", referencedColumnName = "goalId")
    private Goal goal;
}
