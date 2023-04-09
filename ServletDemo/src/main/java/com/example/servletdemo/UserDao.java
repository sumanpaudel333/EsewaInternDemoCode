package com.example.servletdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static boolean insertUserInDb(user usr) {
        boolean flag = false;
        try {
            Connection connection = DbConnection.connectionProvider();
            String q = "insert into usercopy(username,email,password) values(?,?,?)";
            PreparedStatement psr = connection.prepareStatement(q);
            psr.setString(1, usr.getUserName());
            psr.setString(3, usr.getEmail());
            psr.setString(2, usr.getPassword());
            psr.executeUpdate();
            flag = true;
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static List<user> viewUser() throws SQLException, ClassNotFoundException {
        List<user> listOfUser=new ArrayList<>();
        Connection conn = DbConnection.connectionProvider();
        String q = "select * from usercopy";
        PreparedStatement pst = conn.prepareStatement(q);
        ResultSet rst=pst.executeQuery();
        while (rst.next()){
            user user=new user();
            String usrName= rst.getString(1);
            String email=rst.getString(2);
            int id=rst.getInt(5);
            user.setUserName(usrName);
            user.setEmail(email);
            user.setId(id);
            listOfUser.add(user);
        }
        return listOfUser;
    }

    public static void deleteUser(int id) throws SQLException, ClassNotFoundException {
         Connection conn=DbConnection.connectionProvider();
         String q="Delete from usercopy where id=?";
         PreparedStatement pst= conn.prepareStatement(q);
         pst.setInt(1,id);
         pst.executeUpdate();
     }
    public static user getUser(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DbConnection.connectionProvider();
        user user = new user();
        String q = "select * from usercopy where id=?";
        PreparedStatement pst = conn.prepareStatement(q);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            user.setUserName(rs.getString(1));
            user.setEmail(rs.getString(2));
            user.setPassword(rs.getString(2));
        }
        return user;
    }
    public static boolean editUserInDb(user usr) {
        boolean flag = false;
        try {
            Connection connection = DbConnection.connectionProvider();
            String q = "UPDATE usercopy SET username=?,email=?,password=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(q);
            preparedStatement.setString(1, usr.getUserName());
            preparedStatement.setString(2, usr.getEmail());
            preparedStatement.setString(3, usr.getPassword());
            preparedStatement.setInt(4, usr.getId());
            preparedStatement.executeUpdate();
            System.out.println(usr.getUserName());
            System.out.println(usr.getEmail());
            System.out.println(usr.getPassword());
            System.out.println(usr.getId());
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
