package com.userservice.userservice.service;

import com.userservice.userservice.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUser();
    User getUserById(String userId);
}
