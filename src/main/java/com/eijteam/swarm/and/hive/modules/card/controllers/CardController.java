package com.eijteam.swarm.and.hive.modules.card.controllers;

import com.eijteam.swarm.and.hive.modules.card.DTOs.CardDTO;
import com.eijteam.swarm.and.hive.modules.card.DTOs.UserOpenCardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<CardDTO>> findAll(){
        List<CardDTO> cards = cardService.findAll();
        return ResponseEntity.ok().body(cards);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CardDTO> findById(@PathVariable Long id){
        CardDTO card = cardService.findById(id);
        return ResponseEntity.ok().body(card);
    }

    @GetMapping(value = "/open-cards")
    public ResponseEntity<List<UserOpenCardDTO>> findUserOpenCards(){
        List<UserOpenCardDTO> cards = cardService.findUserOpenCards();
        return ResponseEntity.ok().body(cards);
    }

    @GetMapping(value = "/deck-cards")
    public ResponseEntity<List<CardDTO>> findUserDeckCards(){
        List<CardDTO> cards = cardService.findUserDeckCards();
        return ResponseEntity.ok().body(cards);
    }

    @PostMapping(value = "/add-to-deck/{id}")
    public ResponseEntity<CardDTO> addCardToDeck(@PathVariable Long id) {
        CardDTO card = cardService.addCardToDeck(id);
        return ResponseEntity.ok().body(card);
    }

    @PostMapping(value = "/remove-from-deck/{id}")
    public ResponseEntity<CardDTO> removeCardFromDeck(@PathVariable Long id) {
        CardDTO card = cardService.removeCardFromDeck(id);
        return ResponseEntity.ok().body(card);
    }
}
