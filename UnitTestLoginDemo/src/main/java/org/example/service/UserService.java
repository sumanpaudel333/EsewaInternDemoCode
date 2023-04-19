package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    boolean addNewUser(User user);
    boolean deleteById(int id);
    boolean updateUser(int id);
}
