package com.example.cruduserwithspring.controller;

import com.example.cruduserwithspring.model.User;
import com.example.cruduserwithspring.service.UserService;
import com.example.cruduserwithspring.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService user;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/")
    public Collection<User> getAll() {
        this.logger.debug("Get all users");
        return this.user.getAllUsers();
    }

    @PostMapping(value = "/")
    public User addUser(@RequestBody User user) {
        this.logger.debug("Add a new user");
        return this.user.addUser(user);
    }
}
