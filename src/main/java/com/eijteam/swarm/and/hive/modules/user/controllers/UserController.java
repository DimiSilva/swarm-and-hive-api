package com.eijteam.swarm.and.hive.modules.user.controllers;

import com.eijteam.swarm.and.hive.modules.user.DTOs.*;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResDTO> register(@RequestBody RegisterReqDTO userDTO) {
        RegisterResDTO res = userService.register(userDTO);

        URI userGetUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(res.id).toUri();

        return ResponseEntity.created(userGetUri).body(res);
    }
}
