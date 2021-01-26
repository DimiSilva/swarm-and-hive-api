package com.eijteam.swarm.and.hive.modules.stage.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.common.exceptions.UnauthorizedException;
import com.eijteam.swarm.and.hive.common.security.UserSpringSecurity;
import com.eijteam.swarm.and.hive.modules.card.DTOs.UserOpenCardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.stage.DTOs.StageDTO;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.stage.factories.StageDTOFactory;
import com.eijteam.swarm.and.hive.modules.stage.repositories.StageRepository;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.repositories.UserRepository;
import com.eijteam.swarm.and.hive.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StageService {
    @Autowired
    private StageRepository stageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StageDTOFactory stageDTOFactory;

    public List<StageDTO> findAll() {
        UserSpringSecurity userSS = UserService.authenticated();
        if (userSS == null) throw new UnauthorizedException();

        User user = userRepository.findById(userSS.getId()).orElseThrow(() -> new UnauthorizedException());

        List<Stage> stages = stageRepository.findAll();
        Set<Stage> completedStages = user.getCompletedStages();
        return stages.stream().map(stage -> {
            StageDTO dto = stageDTOFactory.createResDTO(stage);
            dto.completed = completedStages.stream().anyMatch(completedStage -> completedStage.getId() == stage.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public StageDTO findById(Long id) {
        Optional<Stage> stage = stageRepository.findById(id);
        return stageDTOFactory.createResDTO(stage.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public StageDTO completeStage(Long id) {
        UserSpringSecurity userSS = UserService.authenticated();
        if (userSS == null) throw new UnauthorizedException();

        User user = userRepository.findById(userSS.getId()).orElseThrow(() -> new UnauthorizedException());

        Stage stage = stageRepository.getOne(id);
        user.getCompletedStages().add(stage);
        userRepository.save(user);

        StageDTO stageDTO = stageDTOFactory.createResDTO(stage);
        stageDTO.completed = true;
        return stageDTO;
    }
}
