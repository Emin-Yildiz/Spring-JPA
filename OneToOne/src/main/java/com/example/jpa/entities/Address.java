package com.example.jpa.entities;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;
    private String houseNumber;
//    @OneToOne(mappedBy = "address")
//    private Student student;
    /*
    İlişkiyi Java tarafında sınıf seviyesinde bidirectional(çift yönlü) tutmak için Address sınıfında Student tipinde bir değişken tanımladık ve değişkene
    @OneToOne anotasyonunu mappedBy ifadesi ile birlikte verdik.
    mappedBy ifadesi Student sınıfı içindeki Address tipindeki değişkenin ismini tutarak ilişkinin Student sınıfı üzerinde tutulduğunu belirtti.
     */
}
