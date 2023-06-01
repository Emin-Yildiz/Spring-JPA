package com.example.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;;import java.util.Set;

enum Gender {
    MALE,
    FEMALE
}

@Entity(name = "student")
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Transient
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "student")
    private Set<Grades> grades;

    private boolean deleted = false;
}