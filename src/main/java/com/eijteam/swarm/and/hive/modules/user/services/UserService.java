package com.eijteam.swarm.and.hive.modules.user.services;

import com.eijteam.swarm.and.hive.common.exceptions.ResourceNotFoundException;
import com.eijteam.swarm.and.hive.common.interfaces.IEmailService;
import com.eijteam.swarm.and.hive.modules.card.entities.Card;
import com.eijteam.swarm.and.hive.modules.card.repositories.CardRepository;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private RegisterDTOFactory registerDTOFactory;

    @Autowired
    private IEmailService emailService;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public RegisterResDTO register(RegisterReqDTO userDTO) {
        User alreadyRegisteredUser = userRepository.findByEmail(userDTO.email);
        if(alreadyRegisteredUser != null) throw new AlreadyRegisteredUserException();

        userDTO.password = bCryptPasswordEncoder.encode(userDTO.password);
        User user = registerDTOFactory.reqDTOToEntity(userDTO);
        final User registeredUser = userRepository.save(user);

        List<Card> cards = cardRepository.findAll();
        cards.forEach(card -> {
            registeredUser.getOpenCards().add(card);
            registeredUser.getDeckCards().add(card);
        });

        userRepository.save(registeredUser);

        emailService.sendRegisterConfirmationEmail(registeredUser);
        return registerDTOFactory.createResDTO(registeredUser);
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
