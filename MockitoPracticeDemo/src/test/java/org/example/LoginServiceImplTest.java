package org.example;

import org.example.Dao.LoginDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.LoginService;
import service.LoginServiceImplDemo;

public class LoginServiceImplTest {
public static LoginDao loginDao;
public static LoginService loginService;
@Test
    public void checkWithValidCredentials(){
    loginDao= Mockito.mock(LoginDao.class);
    loginService=new LoginServiceImplDemo(loginDao);
    Mockito.when(loginDao.authenticate("Ram","hello")).thenReturn(true);
    Assertions.assertTrue(loginService.addUser("Ram","helllo"));
}
@Test
    public void checkWithInvalidCredentials(){
    loginDao=Mockito.mock(LoginDao.class);
    loginService=new LoginServiceImplDemo(loginDao);
    Mockito.when(loginDao.authenticate("Suman","Paudel")).thenReturn(true);
    Assertions.assertFalse(loginService.login("Suman","Hello"));
}
@Test
    public void validatePasswordCheckLengthTrue(){
    loginDao=Mockito.mock(LoginDao.class);
    loginService=new LoginServiceImplDemo(loginDao);
    Assertions.assertTrue(loginService.validatePassword("suman","helloWorld"));
}
    @Test
    public void validatePasswordCheckLengthFalse(){
        loginDao=Mockito.mock(LoginDao.class);
        loginService=new LoginServiceImplDemo(loginDao);
        Assertions.assertFalse(loginService.validatePassword("suman","hello"));
    }
}
