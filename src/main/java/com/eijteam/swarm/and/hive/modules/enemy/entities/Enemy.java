package com.eijteam.swarm.and.hive.modules.enemy.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Enemy implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float attack;
    private Float defense;
    private Float speed;
    private Float honeyReward;

    public Enemy() {}

    public Enemy(Long id, String name, Float attack, Float defense, Float speed, Float honeyReward) {
        this.id = id;
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.honeyReward = honeyReward;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public Float getAttack() { return attack; }

    public Float getDefense() { return defense; }

    public Float getSpeed() { return speed; }

    public Float getHoneyReward() { return honeyReward; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enemy enemy = (Enemy) o;
        return id.equals(enemy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
