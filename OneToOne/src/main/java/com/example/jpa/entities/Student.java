package com.example.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;;

enum Gender {
    MALE,
    FEMALE
}

@Entity(name = "student")
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = false)
    private String name;
    @Transient
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    // aşağıdaki gibi default değer atarsak bu default değer veritabanınada yansır
    private boolean deleted = false;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    /*
    @JoinColumn anotasyonu foreign key (diğer tablonun primary idsi) hangi tablo üzerinde tanımlanacak onu belirtmeye yarar.
    Yani iki tablo üzerindeki ilişki hangi tabloda tutulacak bunu belirtir.
    JoinColumn anotasyonu aldığı name parametresi ile tablo üstüne diğer tablonun primary key değeri hangi isimle tutulacak onu belirtir,
    referencedColumnName ifadesi ise karşı taraftaki tablonun primary key kolonunun ismini belirtir.
     */
}