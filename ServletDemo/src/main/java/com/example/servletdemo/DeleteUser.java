package com.example.servletdemo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse res) throws IOException {
        String s=request.getParameter("id");
        int id=Integer.parseInt(s);
                try {
                        UserDao.deleteUser(id);
                } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                }
                res.sendRedirect("ViewUser");
        }
}
