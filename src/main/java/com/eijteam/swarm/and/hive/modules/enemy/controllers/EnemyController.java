package com.eijteam.swarm.and.hive.modules.enemy.controllers;

import com.eijteam.swarm.and.hive.modules.enemy.entities.Enemy;
import com.eijteam.swarm.and.hive.modules.enemy.services.EnemyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/enemies")
public class EnemyController {
    @Autowired
    private EnemyService enemyService;

    @GetMapping
    public ResponseEntity<List<Enemy>> findAll(){
        List<Enemy> enemies = enemyService.findAll();
        return ResponseEntity.ok().body(enemies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Enemy> findById(@PathVariable Long id){
        Enemy enemy = enemyService.findById(id);
        return ResponseEntity.ok().body(enemy);
    }
}
