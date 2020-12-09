package com.eijteam.swarm.and.hive.modules.stage.services;

import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.repositories.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageService {
    @Autowired
    private StageRepository stageRepository;

    public List<Stage> findAll() {
        return stageRepository.findAll();
    }

    public Stage findById(Long id) {
        Optional<Stage> stage = stageRepository.findById(id);
        return stage.get();
    }
}
