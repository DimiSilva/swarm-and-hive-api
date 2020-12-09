package com.eijteam.swarm.and.hive.modules.stage.controllers;

import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stages")
public class StageController {
    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<Stage>> findAll(){
        List<Stage> stages = stageService.findAll();
        return ResponseEntity.ok().body(stages);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stage> findById(@PathVariable Long id){
        Stage stage = stageService.findById(id);
        return ResponseEntity.ok().body(stage);
    }
}
