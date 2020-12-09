package com.eijteam.swarm.and.hive.modules.user.entities;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.stage.entities.Stage;
import com.eijteam.swarm.and.hive.modules.user.DTOs.UpdateUserDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "user_cards_deck", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Set<Card> deckCards = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_cards_open", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Set<Card> openCards = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_stages_completed", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "stage_id"))
    private Set<Stage> completedStages = new HashSet<>();

    public User() {}

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void update(String name) {
        if(name != null) this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Card> getDeckCards() { return deckCards; }

    public Set<Card> getOpenCards() { return openCards; }

    public Set<Stage> getCompletedStages() { return completedStages; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
