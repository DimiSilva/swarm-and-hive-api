package com.eijteam.swarm.and.hive.modules.enemy.services;

import com.eijteam.swarm.and.hive.modules.enemy.entities.Enemy;
import com.eijteam.swarm.and.hive.modules.enemy.repositories.EnemyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnemyService {
    @Autowired
    private EnemyRepository enemyRepository;

    public List<Enemy> findAll() {
        return enemyRepository.findAll();
    }

    public Enemy findById(Long id) {
        Optional<Enemy> enemy = enemyRepository.findById(id);
        return enemy.get();
    }
}
