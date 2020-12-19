package com.eijteam.swarm.and.hive.modules.stage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Wave implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer position;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @ManyToMany
    @JoinTable(name = "enemies_waves", joinColumns = @JoinColumn(name = "wave_id"), inverseJoinColumns = @JoinColumn(name = "enemy_id"))
    private List<Enemy> enemies = new ArrayList<>();

    public Wave() {}

    public Wave(Long id, Integer position, Stage stage) {
        this.id = id;
        this.position = position;
        this.stage = stage;
    }

    public Long getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public Stage getStage() { return stage; }

    public List<Enemy> getEnemies() { return enemies; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wave wave = (Wave) o;
        return id.equals(wave.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
