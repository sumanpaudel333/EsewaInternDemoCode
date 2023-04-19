package org.example;

import org.example.dao.UserDao;
import org.example.model.User;
import org.example.service.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class UserTest {
    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl userService;

    public UserTest(){
        MockitoAnnotations.openMocks(this);
    }
    @DisplayName("Get all user in the list")
    @Test
    public void testGetAllUser(){
        User usr=new User(1,"Suman","helloNepal","suman@gmail.com");
        User usr1=new User(2,"Saurav","helloLalitpur","saurav@gmail.com");
        User usr2=new User(3,"Shreejal","helloPatan","shree@gmail.com");
        User usr3=new User(4,"Preet","helloKritipur","preet@gmail.com");
        List<User> users=new ArrayList<User>();
        users.add(usr);
        users.add(usr1);
        users.add(usr2);
        users.add(usr3);

        Mockito.when(userDaoMock.getAllUser()).thenReturn(users);
        assertEquals(4,userService.getAllUser().size());
        Mockito.verify(userDaoMock,Mockito.times(1)).getAllUser();
    }
}
