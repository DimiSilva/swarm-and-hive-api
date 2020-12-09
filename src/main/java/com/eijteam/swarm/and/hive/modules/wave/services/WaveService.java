package com.eijteam.swarm.and.hive.modules.wave.services;

import com.eijteam.swarm.and.hive.modules.wave.entities.Wave;
import com.eijteam.swarm.and.hive.modules.wave.repositories.WaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaveService {
    @Autowired
    private WaveRepository waveRepository;

    public List<Wave> findAll() {
        return waveRepository.findAll();
    }

    public Wave findById(Long id) {
        Optional<Wave> wave = waveRepository.findById(id);
        return wave.get();
    }
}
