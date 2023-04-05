package Week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
    public static boolean InsertUserToDb(UserRecord usd) {
        boolean flag = false;
        try {
            Connection cp = DBConnectionProvider.createConnection();

            //inserting user
            String q = "insert into user(username,email,password) values(?,?,?)";
            PreparedStatement pst = cp.prepareStatement(q);
            pst.setString(1, usd.getUsername());
            pst.setString(2, usd.getEmail());
            pst.setInt(3, usd.getPassword().hashCode());
            pst.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean removeUserFromDb(String uname) {
        boolean flag = false;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            Connection cp = DBConnectionProvider.createConnection();

            //deleting user
            String q = "delete from user where username=?";
            PreparedStatement pst = cp.prepareStatement(q);
            pst.setString(1, uname);
            cp.setAutoCommit(false);
            System.out.println("Do you want to commit/rollback the transaction?");
            String decision = br.readLine();
            if (decision.equals("rollback")) {
                cp.rollback();
                System.out.println("Transaction rolled back successfully!");
            } else if (decision.equals("commit")) {
                cp.setAutoCommit(true);
                pst.executeUpdate();
                System.out.println("Transaction committed successfully!");
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static void viewUserFromDb() {
        try {
            Connection cp = DBConnectionProvider.createConnection();

            //deleting user
            String q = "select * from user";
            Statement pst = cp.createStatement();
            ResultSet rst=pst.executeQuery(q);
            while (rst.next()){
                String uname=rst.getString(1);
                String email=rst.getString(2);
                System.out.println("Uname: "+uname);
                System.out.println("Email: "+email);
                System.out.println("-------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean updateUserFromDb(String uname) {
        boolean flag = false;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            Connection cp = DBConnectionProvider.createConnection();

            //updating user
            System.out.println("Enter new username to update for: "+uname);
            String newUsername= br.readLine();
            System.out.println("Enter new email to update for: "+uname);
            String newEmail= br.readLine();
            System.out.println("Enter new password to update for: "+uname);
            String newPassword= br.readLine();
            String q = "UPDATE user SET username = ?, email= ?, password=? WHERE username =?";
            PreparedStatement pst = cp.prepareStatement(q);
            pst.setString(1, newUsername);
            pst.setString(2, newEmail);
            pst.setString(3, newPassword);
            pst.setString(4, uname);
            cp.setAutoCommit(false);
            System.out.println("Do you want to commit/rollback the update?");
            String decision = br.readLine();
            if (decision.equals("rollback")) {
                cp.rollback();
                System.out.println("Update rolled back successfully!");
            } else if (decision.equals("commit")) {
                cp.setAutoCommit(true);
                pst.executeUpdate();
                System.out.println("Update committed successfully!");
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
