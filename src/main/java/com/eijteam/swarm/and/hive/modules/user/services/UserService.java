package com.eijteam.swarm.and.hive.modules.user.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.common.utils.JwtTokenUtil;
import com.eijteam.swarm.and.hive.modules.user.DTOs.LoginReqDTO;
import com.eijteam.swarm.and.hive.modules.user.DTOs.RegisterUserReqDTO;
import com.eijteam.swarm.and.hive.modules.user.DTOs.UpdateUserDTO;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(RegisterUserReqDTO userDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User user = new User(null, userDTO.username, userDTO.email, passwordEncoder.encode(userDTO.password));
        return userRepository.save(user);
    }

    public String login(LoginReqDTO loginDTO) {
        User user = userRepository.getByEmail(loginDTO.email);
        return user.getUsername();
    }

    public User update(Long id, UpdateUserDTO userDTO) {
        try {
            User user = userRepository.getOne(id);
            user.update(userDTO.name);
            return userRepository.save(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void remove(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
