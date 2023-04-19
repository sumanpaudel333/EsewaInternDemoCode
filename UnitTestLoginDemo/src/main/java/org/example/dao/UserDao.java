package org.example.dao;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    List<User> listOfUser = new ArrayList<User>();

    List<User> getAllUser();

    boolean addNewUser(User user);

    boolean deleteById(int id);
    User getUserById(int id);

    boolean updateUser(int id);
}
