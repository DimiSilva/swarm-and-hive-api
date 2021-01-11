package com.eijteam.swarm.and.hive.modules.stage.factories;

import com.eijteam.swarm.and.hive.common.interfaces.IResDTOFactory;
import com.eijteam.swarm.and.hive.modules.stage.DTOs.StageDTO;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import org.springframework.stereotype.Component;

@Component
public class StageDTOFactory implements IResDTOFactory<Stage, StageDTO> {
    @Override
    public StageDTO createResDTO(Stage entity) {
        StageDTO resDTO = new StageDTO();
        resDTO.id = entity.getId();
        resDTO.name = entity.getName();
        resDTO.position = entity.getPosition();
        resDTO.rewardCard = entity.getRewardCard();
        resDTO.difficulty = entity.getDifficulty();
        resDTO.waves = entity.getWaves();
        return resDTO;
    }
}
