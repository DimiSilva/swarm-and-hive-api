package com.eijteam.swarm.and.hive.modules.card.factories;

import com.eijteam.swarm.and.hive.common.interfaces.IResDTOFactory;
import com.eijteam.swarm.and.hive.modules.card.DTOs.UserOpenCardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import org.springframework.stereotype.Component;

@Component
public class UserOpenCardDTOFactory implements IResDTOFactory<Card, UserOpenCardDTO> {
    @Override
    public UserOpenCardDTO createResDTO(Card entity) {
        UserOpenCardDTO resDTO = new UserOpenCardDTO();
        resDTO.id = entity.getId();
        resDTO.name = entity.getName();
        resDTO.description = entity.getDescription();
        resDTO.type = entity.getType();
        resDTO.attack = entity.getAttack();
        resDTO.defense = entity.getDefense();
        resDTO.speed = entity.getSpeed();
        resDTO.attackModifier = entity.getAttackModifier();
        resDTO.defenseModifier = entity.getDefenseModifier();
        resDTO.speedModifier = entity.getSpeedModifier();
        return resDTO;
    }
}
