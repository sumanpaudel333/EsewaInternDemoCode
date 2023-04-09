package com.example.servletdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ViewUser")
public class ViewUser extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) {
        try {
            PrintWriter pw;
            res.setContentType("text/html");
            pw = res.getWriter();
            List<user> users = UserDao.viewUser();
            pw.println("<table border='1'>" +
                    "<tr>" +
                    "<th>Username</th>" +
                    "<th>Email</th>" +
                    "<th>Id</th>" +
                    "<th colspan='1'>Action</th>" +
                    "</tr>");
            for (user usr : users) {
                pw.println("<tr>" +
                        "<td>" + usr.getUserName() + "</td>" +
                        "<td>" + usr.getEmail() + "</td>" +
                        "<td>" + usr.getId() + "</td>" +
                        "<td> <a href='./DeleteUser?id=" + usr.getId() + "'> Delete </td>" +
                        "<td> <a href='./EditUser?id=" + usr.getId() + "'> Edit </td>" +
                        "</tr>");
            }
            pw.println("</table>");
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
