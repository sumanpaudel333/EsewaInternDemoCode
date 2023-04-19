package org.example.service;

import org.example.dao.UserDao;
import org.example.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public boolean addNewUser(User user) {
        if (user.getUserId()==0 || user.getUsername().equals("") || user.getEmail().equals("") || user.getPassword().equals("")){
            throw new RuntimeException("Invalid Login Parameters");
        }
        if (userDao.addNewUser(user)){
            return true;
        }
        return false;
    }


    public boolean deleteById(int id) {
        User user=userDao.getUserById(id);
        if (id<=0){
            throw new RuntimeException("User doesn't exist");
        }
        if (user!=null){
            userDao.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateUser(int id) {
        User user=userDao.getUserById(id);
        if (id<=0){
            throw new RuntimeException("User doesn't exist");
        }
        if (user!=null){
            userDao.getUserById(id);
            return true;
        }
        return false;
    }
}
