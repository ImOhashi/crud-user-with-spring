package com.example.cruduserwithspring.service;

import com.example.cruduserwithspring.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User addUser(User user);
    public User updateUser(User user);
    public void delete(User user);
}
