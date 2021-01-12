package com.eijteam.swarm.and.hive.modules.card.services;

import com.eijteam.swarm.and.hive.common.exceptions.ForbiddenException;
import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.common.exceptions.UnauthorizedException;
import com.eijteam.swarm.and.hive.common.security.UserSpringSecurity;
import com.eijteam.swarm.and.hive.modules.card.DTOs.CardDTO;
import com.eijteam.swarm.and.hive.modules.card.DTOs.UserOpenCardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.factories.CardDTOFactory;
import com.eijteam.swarm.and.hive.modules.card.factories.UserOpenCardDTOFactory;
import com.eijteam.swarm.and.hive.modules.card.repositories.CardRepository;
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
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardDTOFactory cardDTOFactory;

    @Autowired
    private UserOpenCardDTOFactory userOpenCardDTOFactory;

    public List<CardDTO> findAll() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map(card -> cardDTOFactory.createResDTO(card)).collect(Collectors.toList());
    }

    public CardDTO findById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return cardDTOFactory.createResDTO(card.orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public List<UserOpenCardDTO> findUserOpenCards() {
        UserSpringSecurity userSS = UserService.authenticated();
        if(userSS == null) throw new UnauthorizedException();

        User user = userRepository.findById(userSS.getId()).orElseThrow(() -> new UnauthorizedException());
        Set<Card> cards = user.getOpenCards();
        return cards.stream().map(openCard -> {
            UserOpenCardDTO dto = userOpenCardDTOFactory.createResDTO(openCard);
            dto.inDeck = user.getDeckCards().stream().anyMatch(deckCard -> deckCard.getId() == openCard.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<CardDTO> findUserDeckCards() {
        UserSpringSecurity user = UserService.authenticated();
        if(user == null) throw new UnauthorizedException();

        Set<Card> cards = userRepository.findById(user.getId()).orElseThrow(() -> new UnauthorizedException()).getDeckCards();
        return cards.stream().map(card -> cardDTOFactory.createResDTO(card)).collect(Collectors.toList());
    }
}
