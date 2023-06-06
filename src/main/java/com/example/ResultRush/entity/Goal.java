package com.example.ResultRush.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goalId;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String description;
    @Basic(optional = false)
    private Boolean isCompleted;
    @Basic(optional = false)
    private Instant deadline;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private Category category;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id", referencedColumnName = "priorityId")
    private Priority priority;
}
