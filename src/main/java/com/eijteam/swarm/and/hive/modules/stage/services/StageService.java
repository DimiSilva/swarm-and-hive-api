package com.eijteam.swarm.and.hive.modules.stage.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.modules.stage.DTOs.StageDTO;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.factories.StageDTOFactory;
import com.eijteam.swarm.and.hive.modules.stage.repositories.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StageService {
    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private StageDTOFactory stageDTOFactory;

    public List<StageDTO> findAll() {
        List<Stage> stages = stageRepository.findAll();
        return stages.stream().map(stage -> stageDTOFactory.createResDTO(stage)).collect(Collectors.toList());
    }

    public StageDTO findById(Long id) {
        Optional<Stage> stage = stageRepository.findById(id);
        return stageDTOFactory.createResDTO(stage.orElseThrow(() -> new ResourceNotFoundException(id)));
    }
}
