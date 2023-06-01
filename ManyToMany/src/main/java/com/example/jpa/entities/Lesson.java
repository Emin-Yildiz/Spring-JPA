package com.example.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Lesson {

    @Id
    @Column(name = "student_id")
    private int id;

    private String name;

    @ManyToMany(mappedBy = "registeredLessons")
    private Set<Student> students;
}
