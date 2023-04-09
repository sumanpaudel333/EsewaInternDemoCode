package com.example.servletdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String s = request.getParameter("id");
        int id = Integer.parseInt(s);
        user usr;
        try {
            usr = UserDao.getUser(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        pw.println("<form action=\"EditUserComplete\" method=\"POST\">\n" +
                "  <label for=\"name\">Username:</label>\n" +
                "  <input type=\"text\" value=" + usr.getUserName() + " name=\"name\" id=\"name\"><br>\n" +
                "  <label for=\"name\">Id:</label>\n" +
                "  <input type=\"hidden\" value=" + id + " name=\"id\" id=\"id\"><br>\n" +
                "  <label for=\"email\">Email:</label>\n" +
                "  <input type=\"email\" name=\"email\" value=" + usr.getEmail() + " id=\"email\"><br>\n" +
                "  <label for=\"password\" value=" + usr.getPassword() + ">Password:</label>\n" +
                "  <input type=\"password\" name=\"password\" id=\"password\"><br>\n" +
                "  <input type=\"submit\">\n" +
                "</form>");
    }

}
