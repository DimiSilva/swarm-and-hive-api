package com.eijteam.swarm.and.hive.modules.difficulty.repositories;

import com.eijteam.swarm.and.hive.modules.difficulty.entities.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
}
