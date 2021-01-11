package com.eijteam.swarm.and.hive.modules.card.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.modules.card.DTOs.CardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.factories.CardDTOFactory;
import com.eijteam.swarm.and.hive.modules.card.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardDTOFactory cardDTOFactory;

    public List<CardDTO> findAll() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map(card -> cardDTOFactory.createResDTO(card)).collect(Collectors.toList());
    }

    public CardDTO findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return cardDTOFactory.createResDTO(card.orElseThrow(() -> new ResourceNotFoundException(id)));
    }
}
