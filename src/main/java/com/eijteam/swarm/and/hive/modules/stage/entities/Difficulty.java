package com.eijteam.swarm.and.hive.modules.stage.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Difficulty implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float enemyAttackModifier;
    private Float enemyDefenseModifier;
    private Float enemySpeedModifier;
    private Float honeyModifier;
    private Float waveDelayModifier;
    private Float buyCardHoneyIncreaseModifier;

    public Difficulty() {}

    public Difficulty(Long id, String name, Float enemyAttackModifier, Float enemyDefenseModifier, Float enemySpeedModifier, Float honeyModifier, Float waveDelayModifier, Float buyCardHoneyIncreaseModifier) {
        this.id = id;
        this.name = name;
        this.enemyAttackModifier = enemyAttackModifier;
        this.enemyDefenseModifier = enemyDefenseModifier;
        this.enemySpeedModifier = enemySpeedModifier;
        this.honeyModifier = honeyModifier;
        this.waveDelayModifier = waveDelayModifier;
        this.buyCardHoneyIncreaseModifier = buyCardHoneyIncreaseModifier;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getEnemyAttackModifier() {
        return enemyAttackModifier;
    }

    public Float getEnemyDefenseModifier() {
        return enemyDefenseModifier;
    }

    public Float getEnemySpeedModifier() {
        return enemySpeedModifier;
    }

    public Float getHoneyModifier() {
        return honeyModifier;
    }

    public Float getWaveDelayModifier() {
        return waveDelayModifier;
    }

    public Float getBuyCardHoneyIncreaseModifier() {
        return buyCardHoneyIncreaseModifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Difficulty difficulty = (Difficulty) o;
        return id.equals(difficulty.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
