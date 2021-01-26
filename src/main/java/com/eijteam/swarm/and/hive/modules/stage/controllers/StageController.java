package com.eijteam.swarm.and.hive.modules.stage.controllers;

import com.eijteam.swarm.and.hive.modules.stage.DTOs.StageDTO;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.services.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/stages")
public class StageController {
    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<StageDTO>> findAll() {
        List<StageDTO> stages = stageService.findAll();
        return ResponseEntity.ok().body(stages);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StageDTO> findById(@PathVariable Long id) {
        StageDTO stage = stageService.findById(id);
        return ResponseEntity.ok().body(stage);
    }

    @PostMapping(value = "/complete/{id}")
    public ResponseEntity<StageDTO> completeStage(@PathVariable Long id) {
        StageDTO stage = stageService.completeStage(id);
        return ResponseEntity.ok().body(stage);
    }
}
