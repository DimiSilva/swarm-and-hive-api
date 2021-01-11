package com.eijteam.swarm.and.hive.modules.card.controllers;

import com.eijteam.swarm.and.hive.modules.card.DTOs.CardDTO;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<CardDTO>> findUserOpenCards(){
        List<CardDTO> cards = cardService.findAll();
        return ResponseEntity.ok().body(cards);
    }
}
