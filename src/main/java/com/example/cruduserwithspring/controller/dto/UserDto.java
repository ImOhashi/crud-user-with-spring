package com.example.cruduserwithspring.controller.dto;

import com.example.cruduserwithspring.model.User;

public class UserDto {

    private String email;
    private String name;
    private String phone;

    public UserDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.phone = user.getPhone();
    }
}
