package com.example.jpa.entities;

import jakarta.persistence.*;

@Entity
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lessonName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}