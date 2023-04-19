package service;

public interface LoginService {
    public boolean addUser(String username, String password);
    public boolean login(String username,String password);
    public boolean validatePassword(String username,String password);
    }
