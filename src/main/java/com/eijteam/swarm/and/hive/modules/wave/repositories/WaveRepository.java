package com.eijteam.swarm.and.hive.modules.wave.repositories;

import com.eijteam.swarm.and.hive.modules.wave.entities.Wave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaveRepository extends JpaRepository<Wave, Long> {
}
