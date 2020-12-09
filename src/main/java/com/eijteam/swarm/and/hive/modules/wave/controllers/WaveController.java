package com.eijteam.swarm.and.hive.modules.wave.controllers;

import com.eijteam.swarm.and.hive.modules.wave.entities.Wave;
import com.eijteam.swarm.and.hive.modules.wave.services.WaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/waves")
public class WaveController {
    @Autowired
    private WaveService waveService;

    @GetMapping
    public ResponseEntity<List<Wave>> findAll(){
        List<Wave> waves = waveService.findAll();
        return ResponseEntity.ok().body(waves);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Wave> findById(@PathVariable Long id){
        Wave wave = waveService.findById(id);
        return ResponseEntity.ok().body(wave);
    }
}
