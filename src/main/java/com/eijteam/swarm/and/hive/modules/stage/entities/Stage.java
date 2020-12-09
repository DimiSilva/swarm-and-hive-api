package com.eijteam.swarm.and.hive.modules.stage.entities;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.difficulty.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.wave.entities.Wave;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Stage implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer position;
    private String name;

    @ManyToOne
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "reward_card_id")
    private Card rewardCard;

    @OneToMany(mappedBy = "stage")
    private Set<Wave> waves = new HashSet<>();

    public Stage() {}

    public Stage(Long id, Integer position, String name, Difficulty difficulty, Card rewardCard) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.difficulty = difficulty;
        this.rewardCard = rewardCard;
    }

    public Long getId() { return id; }

    public Integer getPosition() { return position; }

    public String getName() { return name; }

    public Difficulty getDifficulty() { return difficulty; }

    public Card getRewardCard() { return rewardCard; }

    public Set<Wave> getWaves() { return waves; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(id, stage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
