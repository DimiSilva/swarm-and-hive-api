package com.eijteam.swarm.and.hive.modules.card.factories;

import com.eijteam.swarm.and.hive.common.interfaces.IResDTOFactory;
import com.eijteam.swarm.and.hive.modules.card.DTOs.CardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import org.springframework.stereotype.Component;

@Component
public class CardDTOFactory implements IResDTOFactory<Card, CardDTO> {
    @Override
    public CardDTO createResDTO(Card entity) {
        CardDTO resDTO = new CardDTO();
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
