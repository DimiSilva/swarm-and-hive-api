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
