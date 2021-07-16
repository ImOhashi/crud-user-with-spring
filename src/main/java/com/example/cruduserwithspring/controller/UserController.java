package com.example.cruduserwithspring.controller;

import com.example.cruduserwithspring.controller.dto.UserDto;
import com.example.cruduserwithspring.model.User;
import com.example.cruduserwithspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService user;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/")
    public ResponseEntity<Collection<User>> getAll() {
        this.logger.debug("Get all users");
        return new ResponseEntity<>(this.user.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<UserDto> addUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        this.logger.debug("Add a new user");

        this.user.addUser(user);

        URI uri = uriComponentsBuilder.path("/user/").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDto(user));
    }

    @PutMapping(value = "/")
    public ResponseEntity<UserDto> updateUser(@RequestBody User newUser, UriComponentsBuilder uriComponentsBuilder) {
        this.logger.debug("Update a user");

        this.user.updateUser(newUser);

        URI uri = uriComponentsBuilder.path("/user/").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDto(newUser));
    }

    @DeleteMapping(value = "/")
    public ResponseEntity deleteUser(@RequestBody User user) {
        this.user.delete(user);
        return ResponseEntity.noContent().build();
    }
}
