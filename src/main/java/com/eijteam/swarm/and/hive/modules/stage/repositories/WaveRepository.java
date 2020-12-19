package com.eijteam.swarm.and.hive.modules.stage.repositories;

import com.eijteam.swarm.and.hive.modules.stage.entities.Wave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaveRepository extends JpaRepository<Wave, Long> {
}
