package Week3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao{
    public static boolean InsertUserToDb(UserRecord usd) {
        boolean flag=false;
        try {
            Connection cp = DBConnectionProvider.createConnection();

            //inserting user
            String q = "insert into user(username,email,password) values(?,?,?)";
            PreparedStatement pst = cp.prepareStatement(q);
            pst.setString(1, usd.getUsername());
            pst.setString(2, usd.getEmail());
            pst.setString(3, usd.getPassword());
            pst.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean removeUserFromDb(String uname){
        boolean flag=false;
        try {
            Connection cp = DBConnectionProvider.createConnection();

            //deleting user
            String q = "delete from user where username=?";
            PreparedStatement pst = cp.prepareStatement(q);
            pst.setString(1, uname);
            pst.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
