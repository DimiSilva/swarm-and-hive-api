package com.eijteam.swarm.and.hive.modules.difficulty.services;

import com.eijteam.swarm.and.hive.modules.difficulty.entities.Difficulty;
import com.eijteam.swarm.and.hive.modules.difficulty.repositories.DifficultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DifficultyService {
    @Autowired
    private DifficultyRepository difficultyRepository;

    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }

    public Difficulty findById(Long id) {
        Optional<Difficulty> difficulty = difficultyRepository.findById(id);
        return difficulty.get();
    }
}
