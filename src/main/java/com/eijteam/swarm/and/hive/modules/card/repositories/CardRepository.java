package com.eijteam.swarm.and.hive.modules.card.repositories;

import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
