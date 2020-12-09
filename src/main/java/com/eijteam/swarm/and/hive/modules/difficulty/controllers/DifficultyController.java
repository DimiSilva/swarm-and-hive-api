package com.eijteam.swarm.and.hive.modules.difficulty.controllers;

import com.eijteam.swarm.and.hive.modules.difficulty.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.difficulty.services.DifficultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/difficulties")
public class DifficultyController {
    @Autowired
    private DifficultyService difficultyService;

    @GetMapping
    public ResponseEntity<List<Difficulty>> findAll(){
        List<Difficulty> difficulties = difficultyService.findAll();
        return ResponseEntity.ok().body(difficulties);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Difficulty> findById(@PathVariable Long id){
        Difficulty difficulty = difficultyService.findById(id);
        return ResponseEntity.ok().body(difficulty);
    }
}
