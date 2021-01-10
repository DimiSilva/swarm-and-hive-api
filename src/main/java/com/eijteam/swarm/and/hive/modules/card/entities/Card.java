package com.eijteam.swarm.and.hive.modules.card.entities;

import com.eijteam.swarm.and.hive.modules.card.enums.CardTypes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String type;
    private Float attack;
    private Float defense;
    private Float speed;
    private Float attackModifier;
    private Float defenseModifier;
    private Float speedModifier;

    public Card() {}

    public Card(Long id, String name, String description, CardTypes type, Float attack, Float defense, Float speed, Float attackModifier, Float defenseModifier, Float speedModifier) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type.getValue();
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.attackModifier = attackModifier;
        this.defenseModifier = defenseModifier;
        this.speedModifier = speedModifier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() { return type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
