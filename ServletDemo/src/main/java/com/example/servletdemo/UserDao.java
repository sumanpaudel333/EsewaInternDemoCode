package com.example.servletdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            flag=true;
            System.out.println(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static ResultSet viewUser() throws SQLException, ClassNotFoundException {
        Connection conn=DbConnection.connectionProvider();
        String q="select * from usercopy";
        PreparedStatement pst= conn.prepareStatement(q);
        ResultSet rst= pst.executeQuery();
       return rst;
    }
}
