package com.example.mongo.controller;

import com.example.mongo.dto.HumanUpdateDTO;
import com.example.mongo.model.Human;
import com.example.mongo.repo.HumanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/human")
public class HumanController {

    @Autowired
    HumanRepo humanRepo;

    @GetMapping()
    public ResponseEntity<List<Human>> getAllHumans(){
        return ResponseEntity.ok(humanRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Human> getHumanById(@PathVariable String id){
        Optional<Human> foundHuman = humanRepo.findById(id);
        if (foundHuman.isPresent()) {
            return ResponseEntity.ok(foundHuman.get());
        }else{
            return null;
        }
    }

    @PostMapping
    public ResponseEntity<Human> add(@RequestBody Human human) {
        return ResponseEntity.ok(humanRepo.save(human));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Human> update(@PathVariable String id, @RequestBody HumanUpdateDTO updateDTO) {
        Optional<Human> foundHuman = humanRepo.findById(id);
        if (foundHuman.isPresent()) {
            Human human = foundHuman.get();
            human.setName(updateDTO.getName());
            return ResponseEntity.ok(humanRepo.save(human));
        }else{
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        humanRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
