package com.eijteam.swarm.and.hive.modules.enemy.repositories;

import com.eijteam.swarm.and.hive.modules.enemy.entities.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
}
