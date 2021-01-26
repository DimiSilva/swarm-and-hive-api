package com.eijteam.swarm.and.hive.modules.stage.DTOs;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.stage.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.stage.entities.Wave;

import java.util.HashSet;
import java.util.Set;

public class StageDTO {
    public Long id;
    public Integer position;
    public String name;
    public Difficulty difficulty;
    public Card rewardCard;
    public Set<Wave> waves = new HashSet<>();
    public boolean completed;
}
