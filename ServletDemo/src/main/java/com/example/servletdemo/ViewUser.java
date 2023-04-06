package com.example.servletdemo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewUser extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) {
        try {
           ResultSet rst= UserDao.viewUser();
            PrintWriter pw=res.getWriter();
            while(rst.next()){
                pw.println("Username: "+rst.getString(1));
                pw.println("Email: "+rst.getString(2));
                pw.println("Id: "+rst.getInt(5));
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
