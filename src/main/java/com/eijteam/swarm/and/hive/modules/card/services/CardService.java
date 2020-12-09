package com.eijteam.swarm.and.hive.modules.card.services;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.get();
    }
}
