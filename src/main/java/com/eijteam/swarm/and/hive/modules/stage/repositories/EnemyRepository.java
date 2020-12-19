package com.eijteam.swarm.and.hive.modules.stage.repositories;

import com.eijteam.swarm.and.hive.modules.stage.entities.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Long> {
}
