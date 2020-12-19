package com.eijteam.swarm.and.hive.modules.user.controllers;

import com.eijteam.swarm.and.hive.modules.user.DTOs.*;
import com.eijteam.swarm.and.hive.modules.user.entities.User;
import com.eijteam.swarm.and.hive.modules.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterUserResDTO> register(@RequestBody RegisterUserReqDTO userDTO) {
        User user = userService.insert(userDTO);
        RegisterUserResDTO res = RegisterUserResDTO.fromUser(user);

        URI userGetUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(userGetUri).body(res);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginReqDTO loginDTO) {
        String res = userService.login(loginDTO);

        return ResponseEntity.ok(res);
    }
/*
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UpdateUserDTO updatedUser) {
        User user = userService.update(id, updatedUser);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        userService.remove(id);
        return ResponseEntity.noContent().build();
    }*/
}
