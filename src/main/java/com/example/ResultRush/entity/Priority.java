package com.example.ResultRush.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priorityId;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String color;
}
