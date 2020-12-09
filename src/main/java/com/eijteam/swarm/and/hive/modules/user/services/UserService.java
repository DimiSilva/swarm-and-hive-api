package com.eijteam.swarm.and.hive.modules.user.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.modules.user.DTOs.InsertUserDTO;
import com.eijteam.swarm.and.hive.modules.user.DTOs.UpdateUserDTO;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(InsertUserDTO userDTO) {
        User user = new User(null, userDTO.name);
        return userRepository.save(user);
    }

    public User update(Long id, UpdateUserDTO userDTO) {
        User user = userRepository.getOne(id);
        user.update(userDTO.name);
        return userRepository.save(user);
    }

    public void remove(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
