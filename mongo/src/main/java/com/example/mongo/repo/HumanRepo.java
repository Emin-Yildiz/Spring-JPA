package com.example.mongo.repo;

import com.example.mongo.model.Human;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HumanRepo extends MongoRepository<Human, String> {


}
