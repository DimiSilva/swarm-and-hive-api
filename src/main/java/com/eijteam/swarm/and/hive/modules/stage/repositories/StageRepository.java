package com.eijteam.swarm.and.hive.modules.stage.repositories;

import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage, Long> {
}
