package service;

import org.example.Dao.LoginDao;

public class LoginServiceImplDemo implements LoginService{
    LoginDao loginDao;

    public LoginServiceImplDemo(LoginDao loginDao) {
        this.loginDao=loginDao;
    }

    public boolean addUser(String username, String password) {
        if (!username.equals("") || password.equals("")){
            return true;
        }
        else {
           return false;
        }
    }
    public boolean login(String username,String password){
        return loginDao.authenticate(username,password);
    }
    public boolean validatePassword(String username,String password){
        if (password.length()<=8){
            char[] passArray=new char[password.length()];
            for (int i=0;i<password.length();i++){
                passArray[i]=password.charAt(i);
                for (int j=0;j<password.length();j++){
                }
            }
            return false;
        }
        else {
            return true;
        }
    }
}
