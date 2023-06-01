package com.example.jpa.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "student")
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100, unique = false)
    private String name;

    @Transient
    private int age;

    @ManyToMany
    @JoinTable(
            name = "student_lessons",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private Set<Lesson> registeredLessons;
    private boolean deleted = false;
}