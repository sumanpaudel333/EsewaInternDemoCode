package com.example.servletdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveServlet")
public class SaveUserDemo extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter pw=response.getWriter();
    response.setContentType("text/html");
    String username=request.getParameter("name");
    String email=request.getParameter("email");
    String password=request.getParameter("password");

    user userDetail=new user(username,email,password);
    boolean status=UserDao.insertUserInDb(userDetail);
    if (status) {
        pw.println("User Inserted Successfully");
    }
    else {
        pw.println("Unable to insert user");
    }
}
}
