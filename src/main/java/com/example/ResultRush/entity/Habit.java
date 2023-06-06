package com.example.ResultRush.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Set;

@Entity
@Data
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer habitId;
    @Basic(optional = false)
    private String title;
    private Set<DayOfWeek> appointedDays;
    @Basic(optional = false)
    private Instant createdUTC;
    @ColumnDefault("0")
    @Basic(optional = false)
    private Integer completedTimes;
}
