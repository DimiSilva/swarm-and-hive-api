package com.eijteam.swarm.and.hive.modules.user.DTOs;

import com.eijteam.swarm.and.hive.modules.user.entities.User;

public class RegisterUserResDTO {
    public Long id;
    public String username;
    public String email;

    public static RegisterUserResDTO fromUser(User user) {
        RegisterUserResDTO registerUserResDTO = new RegisterUserResDTO();
        registerUserResDTO.id = user.getId();
        registerUserResDTO.username = user.getUsername();
        registerUserResDTO.email = user.getEmail();
        return registerUserResDTO;
    }
}
