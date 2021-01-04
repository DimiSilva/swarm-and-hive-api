package com.eijteam.swarm.and.hive.modules.user.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.modules.user.DTOs.*;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.exceptions.AlreadyRegisteredUserException;
import com.eijteam.swarm.and.hive.modules.user.factories.RegisterDTOFactory;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterDTOFactory registerDTOFactory;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public RegisterResDTO register(RegisterReqDTO userDTO) {
        User alreadyRegisteredUser = userRepository.findByEmail(userDTO.email);
        //Incluir exception no handler
        if(alreadyRegisteredUser != null) throw new AlreadyRegisteredUserException();

        userDTO.password = bCryptPasswordEncoder.encode(userDTO.password);
        User user = registerDTOFactory.reqDTOToEntity(userDTO);
        return registerDTOFactory.createResDTO(userRepository.save(user));
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
