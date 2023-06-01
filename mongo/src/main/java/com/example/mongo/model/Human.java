package com.example.mongo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "human")
@Getter
@Setter
public class Human {
    @Id
    private String id;

    private String name;

    public Human(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
