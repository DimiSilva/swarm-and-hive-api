package com.eijteam.swarm.and.hive.modules.stage.repositories;

import com.eijteam.swarm.and.hive.modules.stage.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.stage.entities.Wave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
}
